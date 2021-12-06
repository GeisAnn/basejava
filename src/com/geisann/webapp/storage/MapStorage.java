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
        Resume[] resumes = new Resume[mapStorage.size()];
        int i = 0;
        for (Resume resume : mapStorage.values()) {
            resumes[i] = resume;
            i++;
        }
        Arrays.sort(resumes);
        return resumes;
    }

    @Override
    protected boolean existIndex(Object index) {
        return mapStorage.containsKey(index);
    }

    @Override
    protected String getIndex(String uuid) {
        return uuid;
    }

    @Override
    protected void saveResume(Resume r, Object index) {
        mapStorage.put((String) index, r);
    }

    @Override
    protected void updateResume(Resume r, Object index) {
        mapStorage.put((String) index, r);
    }

    @Override
    protected Resume getResume(Object index) {
        return mapStorage.get(index);
    }

    @Override
    protected void deleteResume(Object index) {
        mapStorage.remove(index);
    }
}
