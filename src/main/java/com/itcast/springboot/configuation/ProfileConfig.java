package com.itcast.springboot.configuation;

import com.itcast.springboot.entity.Man;
import com.itcast.springboot.entity.Student;
import com.itcast.springboot.entity.Teacher;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author lichunmiao
 * @date 2021/5/19
 */
@Configuration

public class ProfileConfig {
    @Profile("production")
    @Bean(name = "teacher")
    @ConfigurationProperties(prefix = "teacher")
    public Man teacher() {
        return new Teacher();
    }

    @Profile("dev")
    @Bean(name = "student")
    @ConfigurationProperties(prefix = "student")
    public Man student() {
        return new Student();
    }
}
