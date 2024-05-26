package com.mpo.happypotter.validator;

import com.mpo.happypotter.model.entity.Entity;
import com.mpo.happypotter.model.enums.CollectionEnum;
import com.mpo.happypotter.model.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SaveDataValidator {

    public static void validateRequest(CollectionEnum collection, Entity request) {
        if (!collection.clazz.isInstance(request)) {
            throw new RuntimeException(ErrorEnum.INVALID_ENTITY_FOR_COLLECTION.description);
        }
    }
}
