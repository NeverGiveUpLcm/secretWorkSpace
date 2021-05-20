package com.itcast.springboot.endPoint;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author lichunmiao
 * @date 2021/5/19
 */
//@Component
public class MyHealth extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //前面可以做一些测试是否健康的操作
        HashMap<String, Object> map = new HashMap<>();
        if (1 == 2) {
            builder.up().status(Status.UP);
            map.put("count", 1);
            map.put("ms", 100);
        } else {
            builder.down().status(Status.OUT_OF_SERVICE);
            map.put("err", "连接超时");
            map.put("ms", 3000);
        }
        builder.withDetail("code", 100)
                .withDetails(map);

    }
}
