package com.fitnesstracker.data.model;

public enum BodyPartEnum {
    BACK("back"),
    CARDIO("cardio"),
    CHEST("chest"),
    LOWER_ARMS("lower arms"),
    LOWER_LEGS("lower legs"),
    NECK("neck"),
    SHOULDERS("shoulders"),
    UPPER_ARMS("upper arms"),
    UPPER_LEGS("upper legs"),
    WAIST("waist");

    private final String apiValue;

    BodyPartEnum(String apiValue) {
        this.apiValue = apiValue;
    }

    public String getApiValue() {
        return apiValue;
    }

    public static BodyPartEnum fromApiValue(String apiValue) {
        for (BodyPartEnum bodyPart : values()) {
            if (bodyPart.getApiValue().equals(apiValue)) {
                return bodyPart;
            }
        }
        throw new IllegalArgumentException("Unknown body part: " + apiValue);
    }
}