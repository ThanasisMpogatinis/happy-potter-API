package com.mpo.happypotter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties
public class AppProperties {

    @Value("${firebase.authentication.json.path}")
    private String json;
}
