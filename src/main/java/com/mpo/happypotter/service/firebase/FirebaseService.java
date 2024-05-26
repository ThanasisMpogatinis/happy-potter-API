package com.mpo.happypotter.service.firebase;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.mpo.happypotter.model.entity.Entity;
import com.mpo.happypotter.model.enums.CollectionEnum;
import com.mpo.happypotter.validator.SaveDataValidator;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FirebaseService {

    protected void save(CollectionEnum collection, Entity entity) {
        SaveDataValidator.validateRequest(collection, entity);
        try {
            final var firestore = FirestoreClient.getFirestore();
            firestore
                .collection(collection.name())
                .document(entity.getId())
                .set(entity)
                .get();
        } catch (ExecutionException | InterruptedException e) {
            log.info("Failure during save :" + Arrays.toString(e.getStackTrace()));
        }
    }

    protected List<QueryDocumentSnapshot> getAllData(CollectionEnum collection) {
        try {
            final var firestore = FirestoreClient.getFirestore();
            return firestore.collection(collection.name()).get().get().getDocuments();
        } catch (ExecutionException | InterruptedException e) {
            log.info("Failure during getAll :" + Arrays.toString(e.getStackTrace()));
            return List.of();
        }
    }

    protected DocumentSnapshot getById(CollectionEnum collection, String id) {
        try {
            final var firestore = FirestoreClient.getFirestore();
            return firestore.collection(collection.name()).document(id).get().get();
        } catch (ExecutionException | InterruptedException e) {
            log.info("Failure during getById :" + Arrays.toString(e.getStackTrace()));
            throw new RuntimeException("Not found"); //TODO
        }
    }
}
