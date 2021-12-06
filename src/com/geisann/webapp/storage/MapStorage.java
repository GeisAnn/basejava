package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    public int size() {
        return mapStorage.size();
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = mapStorage.values().toArray(new Resume[mapStorage.size()]);
        Arrays.sort(resumes);
        return resumes;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return mapStorage.containsKey(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void saveResume(Resume r, Object searchKey) {
        mapStorage.put((String) searchKey, r);
    }

    @Override
    protected void updateResume(Resume r, Object searchKey) {
        mapStorage.put((String) searchKey, r);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return mapStorage.get(searchKey);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        mapStorage.remove(searchKey);
    }
}
