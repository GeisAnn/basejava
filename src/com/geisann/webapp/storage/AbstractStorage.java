package com.geisann.webapp.storage;

import com.geisann.webapp.exception.ExistStorageException;
import com.geisann.webapp.exception.NotExistStorageException;
import com.geisann.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        }
        checkOverflow(r);
        addResume(r, index);
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            updateResume(r, index);
        }
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

    protected abstract void checkOverflow(Resume r);

    protected abstract Resume getResume(int index);

    protected abstract void updateResume(Resume r, int index);

    protected abstract int getIndex(String uuid);

    protected abstract void addResume(Resume r, int index);

    protected abstract void deleteResume(int index);
}
