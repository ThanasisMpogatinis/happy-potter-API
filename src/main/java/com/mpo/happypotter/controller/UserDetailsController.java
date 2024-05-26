package com.mpo.happypotter.controller;

import com.mpo.happypotter.model.dto.CreateUserDTO;
import com.mpo.happypotter.model.FrontEndWrapper;
import com.mpo.happypotter.model.entity.UserDetails;
import com.mpo.happypotter.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mpo.happypotter.utils.Constants.SUCCESSFUL_MESSAGE;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @PostMapping("/create")
    public ResponseEntity<FrontEndWrapper<String>> createUser(@RequestBody CreateUserDTO createUserDTO) {
        log.info("createUser called for email: " + createUserDTO.getEmail());

        userDetailsService.createUser(createUserDTO);

        final var wrapper = FrontEndWrapper.<String>builder()
                .withSuccess(true)
                .withMessage(SUCCESSFUL_MESSAGE)
//                .withBody(addMetricDTO.getMacID()) TODO CREATE UserMessageException to handle error responses
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(wrapper);
    }

    @GetMapping("")
    public ResponseEntity<FrontEndWrapper<UserDetails>> getUser(@RequestParam String id) {
        log.info("getUser called for id: " + id);

        final var result = userDetailsService.getUserDetails(id);

        final var wrapper = FrontEndWrapper.<UserDetails>builder()
                .withSuccess(true)
                .withMessage(SUCCESSFUL_MESSAGE)
                .withBody(result)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(wrapper);
    }

}
