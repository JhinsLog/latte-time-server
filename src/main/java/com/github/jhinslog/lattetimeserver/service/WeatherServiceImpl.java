package com.github.jhinslog.lattetimeserver.service;

import com.github.jhinslog.kma.KmaApiClient;
import com.github.jhinslog.kma.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final KmaApiClient kmaApiClient;

    @Override
    public ApiResponse getUltraSrtNcst(String baseDate, String baseTime, int nx, int ny) throws IOException {
        return kmaApiClient.getUltraSrtNcst(baseDate, baseTime, nx, ny);
    }
}
