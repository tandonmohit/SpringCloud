package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.HelloBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping(path="/hello-world/{name}")
    public HelloBean helloWorld(@PathVariable String name) {
        return new HelloBean("hello world " + name);
    }
}
