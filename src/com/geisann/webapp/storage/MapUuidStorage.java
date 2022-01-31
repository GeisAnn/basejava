package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage <String> {
    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public List<Resume> getAllAsList() {
        return new ArrayList <> (mapStorage.values());
    }

    @Override
    protected boolean isExist(String searchKey) {
        return mapStorage.containsKey(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void saveResume(Resume r, String searchKey) {
        mapStorage.put(searchKey, r);
    }

    @Override
    protected void updateResume(Resume r, String searchKey) {
        mapStorage.put(searchKey, r);
    }

    @Override
    protected Resume getResume(String searchKey) {
        return mapStorage.get(searchKey);
    }

    @Override
    protected void deleteResume(String searchKey) {
        mapStorage.remove(searchKey);
    }
}
