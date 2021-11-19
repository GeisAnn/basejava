package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected void updateResume(Resume r, int index) {
        storage[index] = r;
    }

    protected Resume getResume(int index) {
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
}



