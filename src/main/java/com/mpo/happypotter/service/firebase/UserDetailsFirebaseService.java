package com.mpo.happypotter.service.firebase;

import com.google.firebase.cloud.FirestoreClient;
import com.mpo.happypotter.model.entity.Metric;
import com.mpo.happypotter.model.entity.UserDetails;
import com.mpo.happypotter.model.enums.CollectionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static com.mpo.happypotter.model.enums.CollectionEnum.USER_DETAILS;
import static com.mpo.happypotter.model.enums.ErrorEnum.DEVICE_FOUND_IN_MORE_THAN_ONE_USER;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsFirebaseService {

    private final FirebaseService firebaseService;

    public void save(UserDetails userDetails) {
        firebaseService.save(USER_DETAILS, userDetails);
    }

    public UserDetails getById(String id) {
        final var documentSnapshot = firebaseService.getById(USER_DETAILS, id);
        return documentSnapshot.toObject(UserDetails.class);
    }

    public UserDetails getByMacId(String id) {
        try {
            final var firestore = FirestoreClient.getFirestore();
            final var result = firestore
                    .collection(USER_DETAILS.name())
                    .whereArrayContains("plantMacIDs", id)
                    .get()
                    .get()
                    .getDocuments();
            return result.stream()
                    .map(obj -> obj.toObject(UserDetails.class))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException(DEVICE_FOUND_IN_MORE_THAN_ONE_USER.description)); //TODO
        } catch (ExecutionException | InterruptedException e) {
            log.info("Failure during getById :" + Arrays.toString(e.getStackTrace()));
            throw new RuntimeException("Not found"); //TODO
        }
    }

}
