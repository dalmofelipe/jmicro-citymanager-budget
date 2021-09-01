package com.citymanager.Budget.enums;

public enum Origin {

    FEDERAL("FEDERAL"),
    STATE("STATE"),
    COUNTY("COUNTY");

    private final String value;

    private Origin(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
