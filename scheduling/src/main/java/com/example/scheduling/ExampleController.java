package com.example.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/scheduling")
public class ExampleController {

    @Autowired
    private MyCacheService myCacheService;


    @PostMapping
    public void post(@Valid  @RequestBody Example example){
        myCacheService.save(example);
    }
}
