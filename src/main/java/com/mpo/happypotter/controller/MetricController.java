package com.mpo.happypotter.controller;

import com.mpo.happypotter.model.dto.AddMetricDTO;
import com.mpo.happypotter.model.FrontEndWrapper;
import com.mpo.happypotter.model.entity.Metric;
import com.mpo.happypotter.service.MetricService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mpo.happypotter.utils.Constants.SUCCESSFUL_MESSAGE;

@RestController
@RequestMapping("/api/v1/metric")
@RequiredArgsConstructor
@Slf4j
public class MetricController {

    private final MetricService metricService;

    @PostMapping("/add")
    public ResponseEntity<FrontEndWrapper<String>> addMetric(@RequestBody AddMetricDTO addMetricDTO) {
        log.info("addMetric called for mac: " + addMetricDTO.getMacID());

        metricService.addMetric(addMetricDTO);

        final var wrapper = FrontEndWrapper.<String>builder()
                .withSuccess(true)
                .withMessage(SUCCESSFUL_MESSAGE)
                .withBody(addMetricDTO.getMacID())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(wrapper);
    }

    @GetMapping("")
    public ResponseEntity<FrontEndWrapper<List<Metric>>> addData() {
        log.info("getMetrics called");

        final var result = metricService.getMetrics();

        final var wrapper = FrontEndWrapper.<List<Metric>>builder()
                .withSuccess(true)
                .withMessage(SUCCESSFUL_MESSAGE)
                .withBody(result)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(wrapper);
    }

}
