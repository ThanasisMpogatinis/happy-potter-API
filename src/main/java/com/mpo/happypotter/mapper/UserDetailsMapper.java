package com.mpo.happypotter.mapper;

import com.google.cloud.Timestamp;
import com.mpo.happypotter.model.dto.CreateUserDTO;
import com.mpo.happypotter.model.entity.UserDetails;
import java.util.List;
import java.util.UUID;

public class UserDetailsMapper {

    public static UserDetails mapCreateUserDtoToUserDetails(CreateUserDTO dto) {
        var userDetails = new UserDetails();
        userDetails.setId(UUID.randomUUID().toString());
        userDetails.setUsername(dto.getUsername());
        userDetails.setEmail(dto.getEmail());
        userDetails.setPlants(List.of());
        userDetails.setPlantMacIDs(List.of());
        userDetails.setCreatedAt(Timestamp.now());
        return userDetails;
    }
}
