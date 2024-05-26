package com.mpo.happypotter.service.firebase;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.mpo.happypotter.model.entity.Entity;
import com.mpo.happypotter.model.entity.Metric;
import com.mpo.happypotter.model.enums.CollectionEnum;
import com.mpo.happypotter.validator.SaveDataValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

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
        return response.stream()
                .map((doc) -> doc.toObject(Metric.class))
                .collect(Collectors.toList());
    }

}
