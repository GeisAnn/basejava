package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Name4");
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

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> {
        int res = o1.getFullName().compareTo(o2.getFullName());
        if (res == 0) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
        return res;
    };
}
