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
        int index = indexOfElementPresent(r.getUuid());
        if (index == -1) {
            System.out.println("Resume with uuid " + r.getUuid() + " is not present in the storage");
        } else {
            storage[index] = r;
            System.out.println("Resume was updated");
        }
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("The storage is full");
        } else if (indexOfElementPresent(r.getUuid()) != -1) {
            System.out.println("Resume with uuid " + r.getUuid() + " is already present in the storage");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = indexOfElementPresent(uuid);
        if (index == -1) {
            System.out.println("Resume with uuid " + uuid + " is not present in the storage");
        } else {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        int index = indexOfElementPresent(uuid);
        if (index == -1) {
            System.out.println("Resume with uuid " + uuid + " is not present in the storage");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int indexOfElementPresent(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
