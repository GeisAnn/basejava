package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Name");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void saveResumeToStorage(Resume r, int searchKey) {
        int idx = -(searchKey + 1);
        System.arraycopy(storage, idx, storage, idx + 1, size - idx);
        storage[idx] = r;
    }

    @Override
    protected void deleteResumeFromStorage(int searchKey) {
        int number = size - searchKey - 1;
        if (number > 0) {
            System.arraycopy(storage, searchKey + 1, storage, searchKey, number);
        }
    }
}
