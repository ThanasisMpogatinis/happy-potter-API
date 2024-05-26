package com.mpo.happypotter.model;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class FrontEndWrapper<T> {

    private final String message;
    private final boolean success;
    private final T body;
}
