package com.example.scheduling;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepo extends MongoRepository<Example, String> {
}
