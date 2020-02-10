package com.bubnii.dao.interfaces;

import com.bubnii.model.Person;

public interface PersonDao extends Dao<Person> {
    Person getPersonByCredentials(String username);
}
