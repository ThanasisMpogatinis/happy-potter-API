package com.mpo.happypotter.service;

import com.mpo.happypotter.model.dto.CreateUserDTO;
import com.mpo.happypotter.mapper.UserDetailsMapper;
import com.mpo.happypotter.model.entity.UserDetails;
import com.mpo.happypotter.service.firebase.UserDetailsFirebaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService {

    private final UserDetailsFirebaseService userDetailsFirebaseService;

    public void createUser(CreateUserDTO createUserDTO) {
        //TODO validate username & email etc
        final var userDetails = UserDetailsMapper.mapCreateUserDtoToUserDetails(createUserDTO);
        userDetailsFirebaseService.save(userDetails);
    }

    public UserDetails getUserDetails(String userId) {
        return userDetailsFirebaseService.getById(userId);
    }
 }
