package com.mpo.happypotter.service;

import com.mpo.happypotter.mapper.MetricMapper;
import com.mpo.happypotter.model.dto.AddMetricDTO;
import com.mpo.happypotter.model.entity.Metric;
import com.mpo.happypotter.model.entity.Plant;
import com.mpo.happypotter.service.firebase.MetricFirebaseService;
import com.mpo.happypotter.service.firebase.UserDetailsFirebaseService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetricService {

    private final MetricFirebaseService metricFirebaseService;
    private final UserDetailsFirebaseService userDetailsFirebaseService;

    public void addMetric(AddMetricDTO addMetricDTO) {
        final var metric = MetricMapper.mapAddDataDtoToMetric(addMetricDTO);

        var userDetails = userDetailsFirebaseService.getByMacId(addMetricDTO.getMacID());
        userDetails.setPlants(updatePlantList(userDetails.getPlants(), metric));
        userDetailsFirebaseService.save(userDetails);

        metricFirebaseService.save(metric);
    }

    public List<Metric> getMetrics() {
        return metricFirebaseService.getMetrics();
    }

    private List<Plant> updatePlantList(List<Plant> plants, Metric metric) {
        var updatedList = new ArrayList<Plant>();
        for (var p : plants) {
            if (p.getMacID().equals(metric.getMacID())) {
                p.setLatestMetric(metric);
            }
            updatedList.add(p);
        }
        return updatedList;
    }
}
