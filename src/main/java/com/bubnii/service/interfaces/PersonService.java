package com.bubnii.service.interfaces;

import com.bubnii.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    void add(final Person person); // C

    Person get(final int id); // R

    void update(final Person person); // U

    void delete(final int id); // D

    Person getPersonByCredentials(final String username);
}
