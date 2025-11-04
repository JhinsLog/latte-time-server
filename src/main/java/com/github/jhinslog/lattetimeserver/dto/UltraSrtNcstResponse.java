package com.github.jhinslog.lattetimeserver.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UltraSrtNcstResponse {
    private String baseDate;
    private String baseTime;
    private int nx;
    private int ny;
    private List<UltraSrtNcstItemDto> items;
}
