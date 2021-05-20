package com.itcast.springboot.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lichunmiao
 * @date 2020/12/8
 */
@Component
public class Hello {

    private List<Object> list;

    @Override
    public String toString() {
        for (Object o : list) {
            System.out.println(o);
        }
        return null;
    }
}
