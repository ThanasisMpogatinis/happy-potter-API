package com.mpo.happypotter.validator;

import static com.mpo.happypotter.model.enums.ErrorEnum.INVALID_ENTITY_FOR_COLLECTION;

import com.mpo.happypotter.model.entity.Entity;
import com.mpo.happypotter.model.enums.CollectionEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SaveDataValidator {

    public static void validateRequest(CollectionEnum collection, Entity request) {
        if (!collection.clazz.isInstance(request)) {
            throw new RuntimeException(INVALID_ENTITY_FOR_COLLECTION.description);
        }
    }
}
