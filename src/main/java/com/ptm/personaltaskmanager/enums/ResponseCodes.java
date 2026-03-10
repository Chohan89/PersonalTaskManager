package com.ptm.personaltaskmanager.enums;

public enum ResponseCodes {
    SUCCESS(200, "OK"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_ERROR(500, "Internal Server Error"),
    ERROR(500, "Error");

    private final int code;
    private final String message;

    ResponseCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() { return code; }
    public String message() { return message; }

}
