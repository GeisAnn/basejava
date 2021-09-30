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

    for (int i = 0; ; i++) {
      if (storage[i] == null) {
        storage[i] = r;
        break;
      }
    }
  }

  Resume get(String uuid) {

    int n = size();
    if (n == 0) {
      return null;
    }
    for (int i = 0; i < n; i++) {
      if (storage[i].toString().equals(uuid)) {
        return storage[i];
      }
    }
    return null;
  }


  void delete(String uuid) {
    int n = size();
    if (n == 0) {
      return;
    }
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

    if (storage[0] == null) {
      return 0;
    }
    int count = 1;
    for (int i = 1; ; i++) {
      if (storage[i] != null) {
        count += 1;
      } else {
        break;
      }
    }
    return count;
  }
}

