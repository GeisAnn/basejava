package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ListStorage extends AbstractStorage {
    ArrayList<Resume> listStorage = new ArrayList<>();

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    protected void updateResume(Resume r, int index) {
        listStorage.add(index, r);
    }

    @Override
    protected void addResume(Resume r, int index) {
        listStorage.add(r);
    }

    @Override
    protected Resume getResume(int index) {
        return listStorage.get(index);
    }

    @Override
    protected void deleteResume(int index) {
        listStorage.remove(index);
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    protected int getIndex(String uuid) {
        Iterator<Resume> iterator = listStorage.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            if (Objects.equals(r.getUuid(), uuid)) {
                return listStorage.indexOf(r);
            }
        }
        return -1;
    }
}

