package com.learning.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Lionel Messy");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Lionel", "Messy"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Lionel Messy on version = 1");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Name("Lionel", "Messy on version 2"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-Version=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        return new PersonV1("Lionel Messy on header version = 1");
    }

    @GetMapping(path = "/person/header", headers = "X-API-Version=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        return new PersonV2(new Name("Lionel", "Messy on header version 2"));
    }
}
