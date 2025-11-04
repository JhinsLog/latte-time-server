package com.github.jhinslog.lattetimeserver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UltraSrtNcstItemDto {
    private String category;    //자료 구분 코드
    private String categoryName;//카테고리 명 (예: "기온")
    private String obsrValue;   //실황 값
    private String unit;        //단위 ("ºC")
}