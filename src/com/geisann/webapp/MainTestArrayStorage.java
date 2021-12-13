package com.geisann.webapp;

import com.geisann.webapp.model.Resume;
import com.geisann.webapp.storage.SortedArrayStorage;

/**
 * Test for your com.geisann.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    //private static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    private static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("Name1");
        final Resume r2 = new Resume("Name2");
        final Resume r3 = new Resume("Name3");
        final Resume r4 = new Resume("Name4");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        ARRAY_STORAGE.update(r1);
        ARRAY_STORAGE.update(r4);
        System.out.println("Size: " + ARRAY_STORAGE.size());

        printAll();
        ARRAY_STORAGE.delete(r3.getUuid());
        printAll();
        ARRAY_STORAGE.delete(r4.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllAsList()) {
            System.out.println(r);
        }
    }
}
