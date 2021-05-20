package com.itcast.springboot.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author lichunmiao
 * @date 2021/5/18
 */
@Data
@ToString
public class Boy {
    private Integer id;

    private String boyName;

    private Integer userCP;
}
