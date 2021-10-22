package com.geisann.webapp.storage;

import com.geisann.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    int size();

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();
}
