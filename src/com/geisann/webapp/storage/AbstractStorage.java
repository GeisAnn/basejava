package com.geisann.webapp.storage;

import com.geisann.webapp.exception.ExistStorageException;
import com.geisann.webapp.exception.NotExistStorageException;
import com.geisann.webapp.exception.StorageException;
import com.geisann.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected int size;

    public int size() {
        return size;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            addResume(r, index);
        }
    }

    public Object update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateResume(r, index);
        }
        return null;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return getResume(index);
        }
        throw new NotExistStorageException(uuid);
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(index);
        }
    }

    protected abstract Resume getResume(int index);

    protected abstract void updateResume(Resume r, int index);

    protected abstract int getIndex(String uuid);

    protected abstract void addResume(Resume r, int index);

    protected abstract void deleteResume(int index);
}
