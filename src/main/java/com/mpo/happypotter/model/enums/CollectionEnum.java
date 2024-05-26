package com.mpo.happypotter.model.enums;

import com.mpo.happypotter.model.entity.Metric;
import com.mpo.happypotter.model.entity.UserDetails;

public enum CollectionEnum {
    METRICS(Metric.class),
    USER_DETAILS(UserDetails.class);

    public final Class<?> clazz;

    CollectionEnum(Class<?> clazz) {
        this.clazz = clazz;
    }
}
