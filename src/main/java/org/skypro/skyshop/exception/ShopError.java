package org.skypro.skyshop.exception;

public class ShopError {
    private final String message;
    private final String code;

    public ShopError(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
