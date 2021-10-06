package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        if (!isElementPresent(r)) {
            System.out.println("Resume is not present in the storage");
        } else {
            for (int i = 0; i < size; i++) {
                if (r.getUuid().equals(storage[i].getUuid())) {
                    storage[i] = r;
                }
            }
        }
    }

    public void save(Resume r) {
        if (size == 10000) {
            System.out.println("The storage is full");
        } else {
            if (isElementPresent(r)) {
                System.out.println("Resume is present in the storage");

            } else {
                isElementPresent(r);
                storage[size] = r;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        if (!isElementPresent(uuid)) {
            System.out.println("Resume with uuid " + uuid + " is not present in the storage");
        } else {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (!isElementPresent(uuid)) {
            System.out.println("Resume with uuid " + uuid + " is not present in the storage");
        } else {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private boolean isElementPresent(Resume r) {
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                return true;
            }
        }
        return false;
    }

    private boolean isElementPresent(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }
}
