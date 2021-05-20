package com.itcast.springboot.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author lichunmiao
 * @date 2021/5/12
 */
@Data
public class People {
    private String userName;
    private Integer age;
    //    private LocalDate birth;
    private Pet pet;
}
