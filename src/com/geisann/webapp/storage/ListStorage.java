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
    protected int getIndex(String uuid) {
        Resume r = new Resume(uuid);
        return listStorage.indexOf(r);
    }

    @Override
    protected void saveResume(Resume r, int index) {
        listStorage.add(r);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        listStorage.set(index, r);
    }

    @Override
    protected Resume getResume(int index) {
        return listStorage.get(index);
    }

    @Override
    protected void deleteResume(int index) {
        listStorage.remove(index);
    }
}

