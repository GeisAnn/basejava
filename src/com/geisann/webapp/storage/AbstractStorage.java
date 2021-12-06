package com.geisann.webapp.storage;

import com.geisann.webapp.exception.ExistStorageException;
import com.geisann.webapp.exception.NotExistStorageException;
import com.geisann.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume r) {
        Object searchKey = findSearchKeyIfResumeNotExist(r.getUuid());
        saveResume(r, searchKey);
    }

    public void update(Resume r) {
        Object searchKey = findSearchKeyIfResumeExist(r.getUuid());
        updateResume(r, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = findSearchKeyIfResumeExist(uuid);
        return getResume(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = findSearchKeyIfResumeExist(uuid);
        deleteResume(searchKey);
    }

    private Object findSearchKeyIfResumeNotExist(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object findSearchKeyIfResumeExist(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract boolean isExist(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract void saveResume(Resume r, Object searchKey);

    protected abstract void updateResume(Resume r, Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void deleteResume(Object searchKey);
}
