package com.restfull.yogesh.restfull_demo.controller;

import com.restfull.yogesh.restfull_demo.model.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    //Get
    //URL /hello-world
    //Method

    @GetMapping(path = "/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/helloworldbean")
    public HelloWorldBean helloWorldBean(){
        final HelloWorldBean hello_world_bean = new HelloWorldBean("Hello world bean");
        return hello_world_bean;
    }

    @GetMapping(path = "/helloworldbean/pathvariable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        final HelloWorldBean hello_world_bean = new HelloWorldBean("Hello world: " + name);
        return hello_world_bean;
    }

}
