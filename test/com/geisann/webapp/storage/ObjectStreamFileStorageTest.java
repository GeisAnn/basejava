package com.geisann.webapp.storage;

import com.geisann.webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectStreamFileStorageTest extends AbstractStorageTest {
    public ObjectStreamFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}