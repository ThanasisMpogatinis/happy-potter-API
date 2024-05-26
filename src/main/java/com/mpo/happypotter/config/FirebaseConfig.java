package com.mpo.happypotter.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class FirebaseConfig {

    private final AppProperties appProperties;

    @PostConstruct
    public void configureFirebaseConnection() {
        final var firebaseAuthJson = appProperties.getJson();
        try {
            final var serviceAccount = new FileInputStream(firebaseAuthJson);
            final var options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            log.info("FileNotFound in path:" + firebaseAuthJson);
        }
    }
}
