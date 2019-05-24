package com.example.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.DatabaseMetaData;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MyCacheService {

    private ConcurrentHashMap<String, Example> concurrentHashMap;
    private ExampleRepo exampleRepo;


    @Autowired
    public MyCacheService(
            ConcurrentHashMap<String, Example> concurrentHashMap,
            ExampleRepo exampleRepo
    ){
        this.concurrentHashMap = concurrentHashMap;
        this.exampleRepo = exampleRepo;
    }


    @Scheduled(fixedDelay = 2000)
    public void periodic(){
        concurrentHashMap.forEach(
                (key, value)->{
                    exampleRepo.save(value);
                }
        );
    }


    public void save(Example example){
        concurrentHashMap.put(example.getId(), example);
    }
}
