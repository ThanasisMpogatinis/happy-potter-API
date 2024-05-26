package com.mpo.happypotter.model.entity;

import com.google.cloud.Timestamp;
import com.mpo.happypotter.model.enums.PlantTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Plant extends Entity {
    private String macID;
    private String name;
    private Timestamp createdAt;
    private PlantTypeEnum type;
    private Metric latestMetric;
}
