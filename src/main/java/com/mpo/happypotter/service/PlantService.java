package com.mpo.happypotter.service;

import com.mpo.happypotter.mapper.PlantMapper;
import com.mpo.happypotter.model.dto.AddPlantDTO;
import com.mpo.happypotter.model.entity.Plant;
import com.mpo.happypotter.model.entity.UserDetails;
import com.mpo.happypotter.model.enums.ErrorEnum;
import com.mpo.happypotter.service.firebase.UserDetailsFirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final UserDetailsFirebaseService userDetailsFirebaseService;

    public void addPlantToUser(AddPlantDTO addPlantDTO) {
        var userDetails = userDetailsFirebaseService.getById(addPlantDTO.getUserID());
        checkIfMacAlreadyExists(userDetails, addPlantDTO.getMacID());

        final var plant = PlantMapper.mapAddPlantDtoToPlant(addPlantDTO);
        userDetails.getPlants().add(plant);
        userDetails.getPlantMacIDs().add(plant.getMacID());

        userDetailsFirebaseService.save(userDetails);
    }

    private void checkIfMacAlreadyExists(UserDetails userDetails, String macID) {
        final var exists = userDetails
            .getPlants()
            .stream()
            .map(Plant::getMacID)
            .anyMatch(id -> id.equals(macID));
        if (exists) throw new RuntimeException(
            ErrorEnum.MAC_ID_ALREADY_IN_USER.description
        ); //TODO
    }
}
