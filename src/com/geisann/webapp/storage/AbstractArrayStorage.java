package com.geisann.webapp.storage;

import com.geisann.webapp.exception.StorageException;
import com.geisann.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected int size;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected void saveResume(Resume r, Object index) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        saveResumeToStorage(r, (Integer) index);
        size++;
    }

    protected boolean existIndex(Object index) {
        return (Integer) index >= 0;
    }

    protected void updateResume(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    protected Resume getResume(Object index) {
        return storage[(Integer) index];
    }

    protected void deleteResume(Object index) {
        deleteResumeFromStorage((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void saveResumeToStorage(Resume r, int index);

    protected abstract void deleteResumeFromStorage(int index);
}



