package com.github.jhinslog.lattetimeserver.service;

import com.github.jhinslog.kma.KmaApiClient;
import com.github.jhinslog.kma.dto.ApiResponse;
import com.github.jhinslog.kma.dto.ForecastItem;
import com.github.jhinslog.lattetimeserver.domain.WeatherCategory;
import com.github.jhinslog.lattetimeserver.dto.UltraSrtNcstItemDto;
import com.github.jhinslog.lattetimeserver.dto.UltraSrtNcstResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final KmaApiClient kmaApiClient;

    @Override
    public UltraSrtNcstResponse getUltraSrtNcst(String baseDate, String baseTime, int nx, int ny) throws IOException {
        // 1. KMA API 클라이언트를 통해 원본 데이터 호출
        ApiResponse apiResponse = kmaApiClient.getUltraSrtNcst(baseDate, baseTime, nx, ny);

        // 2. 원본 데이터에서 필요한 'item' 리스트 추출
        List<ForecastItem> forecastItems = apiResponse.getResponse().body.items.itemList;

        // 3. 원본 'ForecastItem' 리스트를 'UltraSrtNcstItemDto' 리스트로 변환
        List<UltraSrtNcstItemDto> dtoList = forecastItems.stream()
                .map(item -> {
                    WeatherCategory category = WeatherCategory.fromCode(item.category);
                    if(category == null){
                        return null;
                    }
                    return UltraSrtNcstItemDto.builder()
                            .category(category.getCode())
                            .categoryName(category.getName())
                            .obsrValue(item.obsrValue)
                            .unit(category.getUnit())
                            .build();
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return UltraSrtNcstResponse.builder()
                .baseDate(baseDate)
                .baseTime(baseTime)
                .nx(nx)
                .ny(ny)
                .items(dtoList)
                .build();
    }
}