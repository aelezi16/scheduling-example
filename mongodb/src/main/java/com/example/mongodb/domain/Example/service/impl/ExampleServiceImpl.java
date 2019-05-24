package com.example.mongodb.domain.Example.service.impl;

import com.example.mongodb.domain.Example.model.Example;
import com.example.mongodb.domain.Example.repo.ExampleRepo;
import com.example.mongodb.domain.Example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ExampleServiceImpl implements ExampleService {

    private ExampleRepo exampleRepo;

    @Autowired
    public ExampleServiceImpl(
            ExampleRepo exampleRepo
    ){
        this.exampleRepo = exampleRepo;
    }


    @Override
    public Example save(Example example) {


        if(example.getId() != null && this.exampleRepo.findById(example.getId()).isPresent())
            return example;


        return this.exampleRepo.save(example);
    }

    @Override
    public Example update(Example example, String id) {

        Example ex = this.exampleRepo.findById(id).get();

        ex.setValue(example.getValue());

        return this.exampleRepo.save(ex);

    }

    @Override
    public Optional<Example> getById(String id) {
        return  this.exampleRepo.findById(id);
    }

    @Override
    public Optional<Example> getByUnique(String unique) {
        return this.exampleRepo.findByUnique(unique);
    }

    @Override
    public List<Example> getAll() {
        return this.exampleRepo.findAll();
    }

    @Override
    public void delete(String id) {
        this.exampleRepo.deleteById(id);
    }
}
