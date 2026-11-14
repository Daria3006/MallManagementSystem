package com.example.mallmanagementsystem.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class InFileBaseRepository<T> implements BaseRepository<T> {
    private final File file;
    private final ObjectMapper objectMapper;


    public InFileBaseRepository(String filePath) {
        this.file = new File(filePath);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public T save(T entity) {
        List<T> entities = findAll();

        entities.removeIf(item -> Objects.equals(extractId(item), extractId(entity)));

        entities.add(entity);

        try {
            objectMapper.writerFor(
                            getEntityTypeReference()
                    )
                    .withDefaultPrettyPrinter()
                    .writeValue(file, entities);
        } catch (IOException e) {
            throw new RuntimeException("Could not save to file", e);
        }

        return entity;
    }

    @Override
    public List<T> findAll() {
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(file, getEntityTypeReference());
        } catch (IOException e) {
            throw new RuntimeException("Could not read from file", e);
        }
    }

    @Override
    public T findById(String id) {
        Optional<T> found = findAll().stream().filter(entity -> Objects.equals(extractId(entity), id)).findFirst();

        return found.orElse(null);
    }

    @Override
    public void delete(String id) {
        List<T> entities = findAll();

        entities.removeIf(item -> Objects.equals(extractId(item), id));

        try {
            objectMapper.writerFor(
                            getEntityTypeReference()
                    )
                    .withDefaultPrettyPrinter()
                    .writeValue(file, entities);
        } catch (IOException e) {
            throw new RuntimeException("Could not save to file", e);
        }
    }

    protected abstract String extractId(T entity);

    protected abstract TypeReference<List<T>> getEntityTypeReference();

    @Override
    public String getNewId() {
        int newId = 1;
        List<String> ids = this.getAllIds();
        while (ids.contains(String.valueOf(newId))){
            newId++;
        }
        return String.valueOf(newId);
    }

    @Override
    public List<String> getAllIds() {
        List<T> entities = findAll();
        List<String> ids = new ArrayList<>();
        for (T entity : entities) {
            ids.add(extractId(entity));
        }
        return ids;
    }



}
