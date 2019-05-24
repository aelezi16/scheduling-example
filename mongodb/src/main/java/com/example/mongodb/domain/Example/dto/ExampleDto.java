package com.example.mongodb.domain.Example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDto {


    private String id;

    @NotNull
    @NotEmpty
    private String unique;

    private String value;
}
