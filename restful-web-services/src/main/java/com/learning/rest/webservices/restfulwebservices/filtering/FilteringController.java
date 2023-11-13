package com.learning.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering") // Field2
    public MappingJacksonValue filtering() {

        SomeBean someBean = new SomeBean("V1", "V2", "V3");

        return applyFiltering(someBean, "field1", "field3");
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("Filed1", "Filed3");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//
//        mappingJacksonValue.setFilters(filters);
//
//        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list") // Field1
    public MappingJacksonValue filteringList() {

        List<SomeBean> list = Arrays.asList(new SomeBean("V1", "V2", "V3"),
                new SomeBean("V4", "V5", "V6"));

        return applyFiltering(list, "field2", "filed3");
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("Filed2", "Filed3");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//
//        mappingJacksonValue.setFilters(filters);
//
//        return mappingJacksonValue;
    }

    private MappingJacksonValue applyFiltering(Object object, String... fieldsToKeep) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(object);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToKeep);

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
