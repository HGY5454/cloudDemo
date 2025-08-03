package com.example.common.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Student {
    private BigInteger id;
    private String name;
    private Integer gender;
    private Integer createTime;
    private Integer updateTime;
    private Integer isDeleted;
}
