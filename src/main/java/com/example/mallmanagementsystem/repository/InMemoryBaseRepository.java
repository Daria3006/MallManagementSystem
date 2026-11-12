package com.example.mallmanagementsystem.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class InMemoryBaseRepository<T> implements BaseRepository<T> {
    protected final List<T> storage = new ArrayList<>();

    @Override
    public T save(T entity) {
        String id = extractId(entity);
        storage.removeIf(item -> Objects.equals(extractId(item), id));
        storage.add(entity);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public T findById(String id) {
        for (T entity : storage) {
            if (Objects.equals(extractId(entity), id)){
                return entity;
            }
        }
        return null;
    }

    @Override
    public void delete(String id){
        storage.remove(findById(id));
    }

    protected abstract String extractId(T entity);

    public String getNewId(){
        int newId = 1;
        List<String> ids = this.getAllIds();
        while (ids.contains(String.valueOf(newId))){
            newId++;
        }
        return String.valueOf(newId);
    }

    public List<String> getAllIds(){
        List<String> ids = new ArrayList<>();
        for (T entity : storage) {
            ids.add(extractId(entity));
        }
        return ids;
    }
}
