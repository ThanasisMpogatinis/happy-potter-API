package com.mpo.happypotter.model.entity;

import com.google.cloud.Timestamp;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
