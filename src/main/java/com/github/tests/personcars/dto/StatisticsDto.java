package com.github.tests.personcars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticsDto {
    private Long personcount;
    private Long carcount;
    private Long uniquevendorcount;

    public static StatisticsDto getStatisticsDto(Long personcount, Long carcount, Long uniquevendorcount) {
        StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setPersoncount(personcount);
        statisticsDto.setCarcount(carcount);
        statisticsDto.setUniquevendorcount(uniquevendorcount);
        return statisticsDto;
    }
}
