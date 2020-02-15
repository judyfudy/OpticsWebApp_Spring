package com.bubnii.dao.interfaces;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    void add(final T t); // C

    T get(final int id); // R

    void update(final T t); // U

    void delete(final int id); // D
}
