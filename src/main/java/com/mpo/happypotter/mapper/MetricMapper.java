package com.mpo.happypotter.mapper;

import com.google.cloud.Timestamp;
import com.mpo.happypotter.model.dto.AddMetricDTO;
import com.mpo.happypotter.model.entity.Metric;

import java.util.UUID;

public class MetricMapper {

    public static Metric mapAddDataDtoToMetric(AddMetricDTO dto) {
        var metric = new Metric();
        metric.setId(UUID.randomUUID().toString());
        metric.setMacID(dto.getMacID());
        metric.setSoilMoisture(dto.getSoilMoisture());
        metric.setBrightness(dto.getBrightness());
        metric.setHumidity(dto.getHumidity());
        metric.setTemperature(dto.getTemperature());
        metric.setTimestamp(Timestamp.now());
        return metric;
    }
}
