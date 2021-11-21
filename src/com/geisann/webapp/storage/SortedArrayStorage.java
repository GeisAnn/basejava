package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addResume(Resume r, int index) {
        int idx = -(index + 1);
        System.arraycopy(storage, idx, storage, idx + 1, size - idx);
        storage[idx] = r;
        plusResume();
    }

    @Override
    protected void deleteResume(int index) {
        int number = size - index - 1;
        if (number > 0) {
            System.arraycopy(storage, index + 1, storage, index, number);
        }
        minusResume();
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
