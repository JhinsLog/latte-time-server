package com.github.jhinslog.lattetimeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //DB 연결 제외
public class LatteTimeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LatteTimeServerApplication.class, args);
    }

}
