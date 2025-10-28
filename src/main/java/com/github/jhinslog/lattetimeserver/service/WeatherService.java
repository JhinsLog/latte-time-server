package com.github.jhinslog.lattetimeserver.service;

import com.github.jhinslog.kma.dto.ApiResponse;

import java.io.IOException;
public interface WeatherService {
    ApiResponse getUltraSrtNcst(String baseDate, String baseTime, int nx, int ny) throws IOException;
}
