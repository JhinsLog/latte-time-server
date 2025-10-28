package com.github.jhinslog.lattetimeserver.config;

import com.github.jhinslog.kma.KmaApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ApiClientConfig {

    @Bean
    public KmaApiClient kmaApiClient() throws IOException {
        return new KmaApiClient();
    }
}
