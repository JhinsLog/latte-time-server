package com.github.jhinslog.lattetimeserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherInfoResponse {

    private String baseDate;
    private String baseTime;

    private Double temperature;     //기온(T1H)
    private Double humidity;        //습도(REH)
    private Double precipitation;   //1시간 강수량(RN1)
    private String precipitationType;   //강수 형태(PTY)
    private Double windSpeed;       //풍속(WSD)
}
