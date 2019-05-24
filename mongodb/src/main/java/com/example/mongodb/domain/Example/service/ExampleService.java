package com.example.mongodb.domain.Example.service;

import com.example.mongodb.domain.Example.model.Example;

import java.util.List;
import java.util.Optional;

public interface ExampleService {

    Example save(Example example);

    Example update(Example example, String id);

    Optional<Example> getById(String id);

    Optional<Example> getByUnique(String unique);

    List<Example> getAll();

    void delete(String id);
}
