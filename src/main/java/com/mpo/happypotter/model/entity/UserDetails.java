package com.mpo.happypotter.model.entity;

import com.google.cloud.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class UserDetails extends Entity {
    private String username;
    private String email;
    private Timestamp createdAt;
    private List<Plant> plants;
    private List<String> plantMacIDs;
}
