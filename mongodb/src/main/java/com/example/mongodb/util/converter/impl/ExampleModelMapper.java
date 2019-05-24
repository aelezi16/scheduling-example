package com.example.mongodb.util.converter.impl;

import com.example.mongodb.domain.Example.dto.ExampleDto;
import com.example.mongodb.domain.Example.model.Example;
import com.example.mongodb.util.converter.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ExampleModelMapper implements ModelMapper<Example, ExampleDto> {

    @Override
    public Example dtoToModel(ExampleDto exampleDto) {
        return new Example(
                exampleDto.getId(), exampleDto.getUnique(), exampleDto.getValue()
        );
    }

    @Override
    public ExampleDto modelToDto(Example example) {
        return new ExampleDto(
                example.getId(), example.getUnique(), example.getValue()
        );
    }
}
