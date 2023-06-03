package com.lucas.github.financial_planning.config.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.lucas.github.financial_planning.config.anotations.ExcludeFromResponse;
import com.lucas.github.financial_planning.config.custom.CustomJsonSerializer;
import com.lucas.github.financial_planning.model.dtos.UserDTO;
import com.lucas.github.financial_planning.utils.ContextUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.lang.reflect.Field;
import java.util.Arrays;



@Configuration
public class JsonSerializationConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        FilterProvider filters = new SimpleFilterProvider().addFilter("excludeFilter",
                SimpleBeanPropertyFilter.serializeAllExcept(getExcludedFields(UserDTO.class)));
        objectMapper.setFilterProvider(filters);


        return objectMapper;
    }

    private String[] getExcludedFields(Class<?> dtoClass) {
        return Arrays.stream(dtoClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(ExcludeFromResponse.class))
                .map(Field::getName)
                .toArray(String[]::new);
    }
}
