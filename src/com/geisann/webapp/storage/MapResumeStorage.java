package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
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
    public List<Resume> getAllAsList() {
        return new ArrayList<>(mapStorage.values());
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return mapStorage.containsValue(searchKey);
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    protected void saveResume(Resume r, Object searchKey) {
        mapStorage.put(r.getUuid(), r);
    }

    @Override
    protected void updateResume(Resume r, Object searchKey) {
        mapStorage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void deleteResume(Object searchKey) {
        mapStorage.remove(((Resume) searchKey).getUuid());
    }
}
