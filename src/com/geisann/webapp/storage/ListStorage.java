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
    protected boolean existIndex(Object index) {
        return (Integer) index >= 0;
    }

    @Override
    protected Integer getIndex(String uuid) {
        Resume r = new Resume(uuid);
        return listStorage.indexOf(r);
    }

    @Override
    protected void saveResume(Resume r, Object index) {
        listStorage.add(r);
    }

    @Override
    protected void updateResume(Resume r, Object index) {
        listStorage.set((Integer) index, r);
    }

    @Override
    protected Resume getResume(Object index) {
        return listStorage.get((Integer) index);
    }

    @Override
    protected void deleteResume(Object index) {
        listStorage.remove(((Integer) index).intValue());
    }
}
