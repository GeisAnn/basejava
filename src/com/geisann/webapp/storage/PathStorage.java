package com.geisann.webapp.storage;

import com.geisann.webapp.exception.StorageException;
import com.geisann.webapp.model.Resume;
import com.geisann.webapp.storage.serializer.Serializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.nio.file.Files.newInputStream;
import static java.nio.file.Files.newOutputStream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;

    private Serializer serializer;

    protected PathStorage(String dir, Serializer serializer) {
        directory = Paths.get(dir);
        this.serializer = serializer;
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::deleteResume);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        try {
            return (int) Files.list(directory).count();
        } catch (IOException e) {
            throw new StorageException("Path count error", null);
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void updateResume(Resume r, Path path) {
        try {
            serializer.doWrite(r, newOutputStream(path));
        } catch (IOException e) {
            throw new StorageException("IO error", path.getFileName().toString(), e);
        }
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void saveResume(Resume r, Path path) {
        try {
            Files.createFile(path);
            serializer.doWrite(r, newOutputStream(path));
        } catch (IOException e) {
            throw new StorageException("Couldn't create file(path)" + path.toAbsolutePath(), path.getFileName().toString(), e);
        }
    }

    @Override
    protected Resume getResume(Path path) {
        try {
            return serializer.doRead(newInputStream(path));
        } catch (IOException e) {
            throw new StorageException("IO error", path.getFileName().toString(), e);
        }
    }

    @Override
    protected void deleteResume(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("File delete error", path.getFileName().toString());
        }
    }

    @Override
    protected List<Resume> getAllAsList() {
        try {
            return Files.list(directory).map(this::getResume).collect(Collectors.toList());
        } catch (IOException e) {
            throw new StorageException("Directory is empty", null);
        }
    }
}
