package com.geisann.webapp.storage;

import com.geisann.webapp.exception.StorageException;
import com.geisann.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage <Integer>{

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

    public List<Resume> getAllAsList() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    protected void saveResume(Resume r, Integer searchKey) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        saveResumeToStorage(r, searchKey);
        size++;
    }

    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    protected void updateResume(Resume r, Integer searchKey) {
        storage[searchKey] = r;
    }

    protected Resume getResume(Integer searchKey) {
        return storage[searchKey];
    }

    protected void deleteResume(Integer searchKey) {
        deleteResumeFromStorage(searchKey);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void saveResumeToStorage(Resume r, int searchKey);

    protected abstract void deleteResumeFromStorage(int searchKey);
}



