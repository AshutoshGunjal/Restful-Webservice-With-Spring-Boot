package com.learning.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"Field1","Field2"})
public class SomeBean {

    private String Field1;
    @JsonIgnore
    private String Field2;
    private String Field3;

    public String getField1() {
        return Field1;
    }

    public String getField2() {
        return Field2;
    }

    public String getField3() {
        return Field3;
    }

    public SomeBean(String field1, String field2, String field3) {
        this.Field1 = field1;
        this.Field2 = field2;
        this.Field3 = field3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "Field1='" + Field1 + '\'' +
                ", Field2='" + Field2 + '\'' +
                ", Field3='" + Field3 + '\'' +
                '}';
    }
}
