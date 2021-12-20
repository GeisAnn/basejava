package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage <Integer>{
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
    public List<Resume> getAllAsList() {
        return new ArrayList<>(listStorage);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void saveResume(Resume r, Integer searchKey) {
        listStorage.add(r);
    }

    @Override
    protected void updateResume(Resume r, Integer searchKey) {
        listStorage.set(searchKey, r);
    }

    @Override
    protected Resume getResume(Integer searchKey) {
        return listStorage.get(searchKey);
    }

    @Override
    protected void deleteResume(Integer searchKey) {
        listStorage.remove(searchKey.intValue());
    }
}
