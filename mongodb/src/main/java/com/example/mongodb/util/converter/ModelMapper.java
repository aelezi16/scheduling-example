package com.example.mongodb.util.converter;

public interface ModelMapper<Model, Dto> {

    Model dtoToModel(Dto dto);

    Dto modelToDto(Model model);
}
