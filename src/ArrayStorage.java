import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        int i = size();
        storage[i] = r;
    }

    Resume get(String uuid) {
        Resume r1 = new Resume();
        for (Resume r : storage) {
            if (r.toString().equals(uuid)) {
                r1 = r;
                break;
            }
        }
        return r1;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return 0;
    }
}
