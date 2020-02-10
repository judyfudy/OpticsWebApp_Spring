package com.bubnii.service.interfaces;

import com.bubnii.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();

    void add(Person person); // C

    Person get(int id); // R

    void update(Person person); // U

    void delete(int id); // D

    Person getPersonByCredentials(String username);
}
