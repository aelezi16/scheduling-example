package com.example.mongodb.domain.Example.controller;

import com.example.mongodb.domain.Example.dto.ExampleDto;
import com.example.mongodb.domain.Example.model.Example;
import com.example.mongodb.domain.Example.service.ExampleService;
import com.example.mongodb.util.converter.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    private ExampleService exampleService;
    private ModelMapper<Example, ExampleDto> modelMapper;



    @Autowired
    public ExampleController(
            ExampleService exampleService,
            ModelMapper<Example, ExampleDto> modelMapper
    ){
        this.exampleService = exampleService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ExampleDto post(@Valid @RequestBody ExampleDto dto){

        return Optional.of(
                dto
        ).map(modelMapper::dtoToModel)
          .map(exampleService::save)
          .map(modelMapper::modelToDto).get();
    }

    @PutMapping("/{id}")
    public ExampleDto put(@PathVariable String id, @Valid @RequestBody ExampleDto dto){
        return Optional.of(
                dto
        ).map(modelMapper::dtoToModel)
                .map(d -> exampleService.update(d, id))
                .map(modelMapper::modelToDto).get();
    }

    @GetMapping
    public List<ExampleDto> getAll(){
        return exampleService.getAll()
                .stream()
                .map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("id/{id}")
    public ExampleDto getById(@PathVariable String id){
        Optional<ExampleDto> dtoOptional = exampleService.getById(id).map(modelMapper::modelToDto);

        return dtoOptional.isPresent()?dtoOptional.get():null;
    }

    @GetMapping("/uni/{unique}")
    public ExampleDto getByUnique(@PathVariable String unique){
        Optional<ExampleDto> dtoOptional = exampleService.getByUnique(unique).map(modelMapper::modelToDto);

        return dtoOptional.isPresent()?dtoOptional.get():null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        exampleService.delete(id);
    }

}
