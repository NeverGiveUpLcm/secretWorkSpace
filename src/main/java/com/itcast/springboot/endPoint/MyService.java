package com.itcast.springboot.endPoint;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Queue;

/**
 * @author lichunmiao
 * @date 2021/5/19
 */
@Component
public class MyService {
    Counter counter;

    public MyService(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("myservice.method.running.counter");
    }

    public void hello() {
        counter.increment();
    }
}


