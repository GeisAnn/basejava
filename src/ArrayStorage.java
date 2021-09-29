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
    int n = size();
    for (int i = 0; i < n; i++) {
      if (storage[i].toString().equals(uuid)) {
        storage[i] = storage[i + 1];
        for (int k = i + 1; k + 1 < n; k++) {
          storage[k] = storage[k + 1];
        }
        storage[n - 1] = null;
        break;
      }
    }

  }

  /**
   * @return array, contains only Resumes in storage (without null)
   */
  Resume[] getAll() {
    return Arrays.copyOfRange(storage, 0, size());
  }

  int size() {
    int count = 0;
    for (Resume r : storage) {
      if (r != null) {
        count += 1;
      }
    }
    return count;
  }
}
