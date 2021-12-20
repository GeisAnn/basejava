package com.geisann.webapp.storage;

import com.geisann.webapp.exception.ExistStorageException;
import com.geisann.webapp.exception.NotExistStorageException;
import com.geisann.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage <SK> implements Storage {

    Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    public void save(Resume r) {
        SK searchKey = findSearchKeyIfResumeNotExist(r.getUuid());
        saveResume(r, searchKey);
    }

    public void update(Resume r) {
        SK searchKey = findSearchKeyIfResumeExist(r.getUuid());
        updateResume(r, searchKey);
    }

    public Resume get(String uuid) {
        SK searchKey = findSearchKeyIfResumeExist(uuid);
        return getResume(searchKey);
    }

    public void delete(String uuid) {
        SK searchKey = findSearchKeyIfResumeExist(uuid);
        deleteResume(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = getAllAsList();
        list.sort(RESUME_COMPARATOR);
        return list;
    }

    private SK findSearchKeyIfResumeNotExist(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK findSearchKeyIfResumeExist(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract boolean isExist(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    protected abstract void saveResume(Resume r, SK searchKey);

    protected abstract void updateResume(Resume r, SK searchKey);

    protected abstract Resume getResume(SK searchKey);

    protected abstract void deleteResume(SK searchKey);

    protected abstract List<Resume> getAllAsList();
}
