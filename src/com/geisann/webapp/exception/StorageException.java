package com.geisann.webapp.exception;

public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String msg, String uuid) {
        super(msg);
        this.uuid = uuid;
    }

    public StorageException(String message, String uuid, Exception e) {
        super(message, e);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
