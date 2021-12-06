package com.geisann.webapp.storage;

import com.geisann.webapp.exception.ExistStorageException;
import com.geisann.webapp.exception.NotExistStorageException;
import com.geisann.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume r) {
        Object index = indexOfNotExistResume(r.getUuid());
        saveResume(r, index);
    }

    public void update(Resume r) {
        Object index = indexOfExistResume(r.getUuid());
        updateResume(r, index);
    }

    public Resume get(String uuid) {
        Object index = indexOfExistResume(uuid);
        return getResume(index);
    }

    public void delete(String uuid) {
        Object index = indexOfExistResume(uuid);
        deleteResume(index);
    }

    private Object indexOfNotExistResume(String uuid) {
        Object index = getIndex(uuid);
        if (existIndex(index)) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }

    private Object indexOfExistResume(String uuid) {
        Object index = getIndex(uuid);
        if (!existIndex(index)) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    protected abstract boolean existIndex(Object index);

    protected abstract Object getIndex(String uuid);

    protected abstract void saveResume(Resume r, Object index);

    protected abstract void updateResume(Resume r, Object index);

    protected abstract Resume getResume(Object index);

    protected abstract void deleteResume(Object index);
}
