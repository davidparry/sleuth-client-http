package com.davidparry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * If udp is not an option
 * opentracing.jaeger.http-sender.url = http://jaegerhost:portNumber/api/traces
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
