package com.mpo.happypotter.controller;

import static com.mpo.happypotter.utils.Constants.SUCCESSFUL_MESSAGE;

import com.mpo.happypotter.model.FrontEndWrapper;
import com.mpo.happypotter.model.dto.AddPlantDTO;
import com.mpo.happypotter.service.PlantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/plant")
@RequiredArgsConstructor
@Slf4j
public class PlantController {

    private final PlantService plantService;

    @PostMapping("/add")
    public ResponseEntity<FrontEndWrapper<String>> addPlantToUser(
        @RequestBody AddPlantDTO addPlantDTO
    ) {
        log.info(
            "addPlantToUser called for userID: " +
            addPlantDTO.getUserID() +
            " and macID: " +
            addPlantDTO.getMacID()
        );

        plantService.addPlantToUser(addPlantDTO);

        final var wrapper = FrontEndWrapper
            .<String>builder()
            .withSuccess(true)
            .withMessage(SUCCESSFUL_MESSAGE)
            .build();
        return ResponseEntity.status(HttpStatus.OK).body(wrapper);
    }
}
