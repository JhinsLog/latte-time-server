package com.github.jhinslog.lattetimeserver.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum WeatherCategory {

    PTY("PTY", "강수형태", ""),
    REH("REH", "습도", "%"),
    RN1("RN1", "1시간 강수량", "mm"),
    T1H("T1H", "기온", "℃"),
    UUU("UUU", "동서바람성분", "m/s"),
    VEC("VEC", "풍향", "deg"),
    VVV("VVV", "남북바람성분", "m/s"),
    WSD("WSD", "풍속", "m/s");

    private final String code;
    private final String name;
    private final String unit;

    WeatherCategory(String code, String name, String unit) {
        this.code = code;
        this.name = name;
        this.unit = unit;
    }

    public static WeatherCategory fromCode(String code) {
        return Arrays.stream(values())
                .filter(category -> category.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
