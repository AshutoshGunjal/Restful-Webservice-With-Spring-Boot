package com.learning.rest.webservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;
    // Constructor Injection
    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Helloooooo REST API Worldddd";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Helloooooo REST API Worldddd Bean");
    }

    //path parameters `/users`, `/users/{id}`, or `/posts`
    // build api as /hello-world/path-variable/{name}
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {

        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
//        return "Helloooooo REST API Worldddd V2";

        //Example: en - English (Good Morning)
        //Example: nl - Dutch (Goedemorgan)
        //Example: fr - French (Bonjour)


    }
}
