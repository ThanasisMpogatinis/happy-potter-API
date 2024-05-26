package com.mpo.happypotter.model.dto;

import lombok.Getter;

@Getter
public class AddMetricDTO {

    private String macID;
    private float soilMoisture;
    private float brightness;
    private float humidity;
    private float temperature;
}
