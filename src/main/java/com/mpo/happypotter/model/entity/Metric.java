package com.mpo.happypotter.model.entity;

import com.google.cloud.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Metric extends Entity {

    private String macID;
    private float soilMoisture;
    private float brightness;
    private float humidity;
    private float temperature;
    private Timestamp timestamp;
}
