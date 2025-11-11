package com.github.jhinslog.lattetimeserver.service;

import com.github.jhinslog.kma.KmaApiClient;
import com.github.jhinslog.kma.dto.ApiResponse;
import com.github.jhinslog.kma.dto.ForecastItem;
import com.github.jhinslog.lattetimeserver.domain.WeatherCategory;
import com.github.jhinslog.lattetimeserver.dto.WeatherInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final KmaApiClient kmaApiClient;
    @Override
    public WeatherInfoResponse getUltraSrtNcst(String baseDate, String baseTime, int nx, int ny) throws IOException {
        // 1. KMA API 클라이언트를 통해 원본 데이터 호출
        ApiResponse apiResponse = kmaApiClient.getUltraSrtNcst(baseDate, baseTime, nx, ny);
        // 2. 원본 데이터에서 필요한 'item' 리스트 추출
        List<ForecastItem> forecastItems = apiResponse.getResponse().body.items.itemList;

        WeatherInfoResponse.WeatherInfoResponseBuilder responseBuilder = WeatherInfoResponse.builder()
                .baseDate(baseDate)
                .baseTime(baseTime);

        for(ForecastItem item : forecastItems) {
            WeatherCategory category = WeatherCategory.fromCode(item.category);
            if (category == null) continue;

            switch (category) {
                case T1H:
                    responseBuilder.temperature(Double.parseDouble(item.obsrValue));
                    break;
                case REH:
                    responseBuilder.humidity(Double.parseDouble(item.obsrValue));
                    break;
                case RN1:
                    responseBuilder.precipitation(Double.parseDouble(item.obsrValue));
                    break;
                case PTY:
                    responseBuilder.precipitationType(convertPtyCodeToString(item.obsrValue));
                    break;
                case WSD:
                    responseBuilder.windSpeed(Double.parseDouble(item.obsrValue));
                    break;
            }
        }

        return responseBuilder.build();

    }

    private String convertPtyCodeToString(String ptyCode) {
        return switch (ptyCode) {
            case "0" -> "강수 없음";
            case "1" -> "비";
            case "2" -> "비/눈";
            case "3" -> "눈";
            case "5" -> "빗방울";
            case "6" -> "빗방울눈날림";
            case "7" -> "눈날림";
            default -> "알 수 없음";
        };
    }
}