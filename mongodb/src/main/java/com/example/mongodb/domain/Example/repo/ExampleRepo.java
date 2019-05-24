package com.example.mongodb.domain.Example.repo;

import com.example.mongodb.domain.Example.model.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExampleRepo extends MongoRepository<Example, String> {

    Optional<Example> findById(String id);
    Optional<Example> findByUnique(String unique);

    List<Example> findAll();

    void deleteById(String id);
}
