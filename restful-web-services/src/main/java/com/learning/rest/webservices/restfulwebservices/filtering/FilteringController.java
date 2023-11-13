package com.learning.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("V1", "V2", "V3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("V1", "V2", "V3"),
                new SomeBean("V4", "V5", "V6"));
    }
}
