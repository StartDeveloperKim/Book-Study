package org.example.chapter4.importer;

public enum Attributes {
    PATH("path"), WIDTH("width"), HEIGHT("height"), TYPE("type"),
    PATIENT("patient"), AMOUNT("amount"), ADDRESS("address"), BODY("body");

    private final String name;

    Attributes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
