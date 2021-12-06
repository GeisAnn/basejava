package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveResumeToStorage(Resume r, int searchKey) {
        storage[size] = r;
    }

    @Override
    protected void deleteResumeFromStorage(int searchKey) {
        storage[searchKey] = storage[size - 1];
    }
}
