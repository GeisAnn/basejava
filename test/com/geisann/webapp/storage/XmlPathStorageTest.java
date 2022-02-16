package com.geisann.webapp.storage;

import com.geisann.webapp.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest{
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }
}
