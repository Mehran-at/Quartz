package com.kingcode.quartz.simpleService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleServiceImplementation implements SimpleService {

    @Override
    public void simpleMethod() {
        System.out.println("I got executed...!");
        log.info("simpleMethod() got executed...!");
    }
}