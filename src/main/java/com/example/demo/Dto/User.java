package com.example.demo.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
@ApiModel(value="user对象",description="用户对象user")
public class User {

    @NotNull(message="userName不能空")
    @ApiModelProperty(value="姓名",name="name",required=true)
    private String name;

    @ApiModelProperty(value="年龄",name="age",required=true)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
