package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloBean {

    private String message;

    public HelloBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
