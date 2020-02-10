package com.bubnii.dao.interfaces;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    void add(T t); // C

    T get(int id); // R

    void update(T t); // U

    void delete(int id); // D
}
