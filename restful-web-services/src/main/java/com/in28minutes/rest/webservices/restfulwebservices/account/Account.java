package com.in28minutes.rest.webservices.restfulwebservices.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detai;s about acct")
public class Account {

    private Integer id;
    @ApiModelProperty(notes="Savings or Current")
    private String type;
    private String owner;

    public Account(Integer id, String type, String owner) {
        this.id = id;
        this.type = type;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
