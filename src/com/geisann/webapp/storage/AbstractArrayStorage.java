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

    protected void saveResume(Resume r, Object searchKey) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        saveResumeToStorage(r, (Integer) searchKey);
        size++;
    }

    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    protected void updateResume(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }

    protected Resume getResume(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    protected void deleteResume(Object searchKey) {
        deleteResumeFromStorage((Integer) searchKey);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void saveResumeToStorage(Resume r, int searchKey);

    protected abstract void deleteResumeFromStorage(int searchKey);
}



