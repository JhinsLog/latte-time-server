package com.github.jhinslog.lattetimeserver.service;

import com.github.jhinslog.lattetimeserver.dto.UltraSrtNcstResponse;
import com.github.jhinslog.lattetimeserver.dto.WeatherInfoResponse;

import java.io.IOException;
public interface WeatherService {
    //ApiResponse getUltraSrtNcst(String baseDate, String baseTime, int nx, int ny) throws IOException;
    //UltraSrtNcstResponse getUltraSrtNcst(String baseDate, String baseTime, int nx, int ny) throws IOException;

    WeatherInfoResponse getUltraSrtNcst(String baseDate, String baseTime, int nx, int ny) throws IOException;
}
