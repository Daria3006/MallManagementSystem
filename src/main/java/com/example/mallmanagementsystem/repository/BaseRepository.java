package com.example.mallmanagementsystem.repository;

import java.util.List;

public interface BaseRepository<T> {
    T save(T entity);
    List<T> findAll();
    T findById(String id);
    void delete (String id);
}
