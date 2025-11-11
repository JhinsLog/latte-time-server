package com.github.jhinslog.lattetimeserver.controller;

import com.github.jhinslog.lattetimeserver.dto.UltraSrtNcstResponse;
import com.github.jhinslog.lattetimeserver.dto.WeatherInfoResponse;
import com.github.jhinslog.lattetimeserver.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/ultra-srt-ncst")
    public WeatherInfoResponse getUltraSrtNcst(
            @RequestParam String baseDate,
            @RequestParam String baseTime,
            @RequestParam int nx,
            @RequestParam int ny) throws IOException {
        return weatherService.getUltraSrtNcst(baseDate, baseTime, nx, ny);
    }
}