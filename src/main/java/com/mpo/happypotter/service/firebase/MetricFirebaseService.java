package com.mpo.happypotter.service.firebase;

import com.mpo.happypotter.model.entity.Metric;
import com.mpo.happypotter.model.enums.CollectionEnum;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MetricFirebaseService {

    private final FirebaseService firebaseService;

    public void save(Metric metric) {
        firebaseService.save(CollectionEnum.METRICS, metric);
    }

    public List<Metric> getMetrics() {
        final var response = firebaseService.getAllData(CollectionEnum.METRICS);
        return response
            .stream()
            .map(doc -> doc.toObject(Metric.class))
            .collect(Collectors.toList());
    }
}
