package com.itcast.springboot.endPoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @author lichunmiao
 * @date 2021/5/19
 */
@Component
@Endpoint(id = "container")
public class DockerEndpoint {

    @ReadOperation
    public Map getDockerInfo() {
        return Collections.singletonMap("info", "docker started...");
    }

    @WriteOperation
    private void restartDocker() {
        System.out.println("docker restarted....");
    }
}
