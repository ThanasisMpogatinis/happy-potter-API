package com.mpo.happypotter.mapper;

import com.google.cloud.Timestamp;
import com.mpo.happypotter.model.dto.AddPlantDTO;
import com.mpo.happypotter.model.entity.Plant;

import java.util.UUID;

public class PlantMapper {

    public static Plant mapAddPlantDtoToPlant(AddPlantDTO dto) {
        var plant = new Plant();
        plant.setId(UUID.randomUUID().toString());
        plant.setMacID(dto.getMacID());
        plant.setCreatedAt(Timestamp.now());
        return plant;
    }
}
