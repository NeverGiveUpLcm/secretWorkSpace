package com.itcast.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author lichunmiao
 * @date 2021/5/18
 */
@SpringBootTest
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() {
        Long count = jdbcTemplate.queryForObject("select count(*) from boy ", Long.class);
        System.out.println(count);
        System.out.println(dataSource.getClass());

    }
}
