package com.mpo.happypotter.model.enums;

public enum ErrorEnum {
    INVALID_ENTITY_FOR_COLLECTION("The entity trying to be saved should not be in the specific collection"),
    DEVICE_FOUND_IN_MORE_THAN_ONE_USER("This device is connected to more that one user"),
    MAC_ID_ALREADY_IN_USER("This device is already connected to user");

    public final String description;

    ErrorEnum(String description) {
        this.description = description;
    }

}
