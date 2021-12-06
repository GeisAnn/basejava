package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listStorage = new ArrayList<>();

    @Override
    public int size() {
        return listStorage.size();
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume r = new Resume(uuid);
        return listStorage.indexOf(r);
    }

    @Override
    protected void saveResume(Resume r, Object searchKey) {
        listStorage.add(r);
    }

    @Override
    protected void updateResume(Resume r, Object searchKey) {
        listStorage.set((Integer) searchKey, r);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return listStorage.get((Integer) searchKey);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        listStorage.remove(((Integer) searchKey).intValue());
    }
}
