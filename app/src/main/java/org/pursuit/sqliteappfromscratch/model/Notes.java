package org.pursuit.sqliteappfromscratch.model;

public class Notes {

    public static String name;
    public static String message;

    public Notes(String name, String message) {
        this.name = name;
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
