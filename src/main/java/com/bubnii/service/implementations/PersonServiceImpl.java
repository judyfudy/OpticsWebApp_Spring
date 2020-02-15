package com.bubnii.service.implementations;

import com.bubnii.dao.interfaces.PersonDao;
import com.bubnii.model.Person;
import com.bubnii.service.interfaces.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public void add(final Person person) {
        if (person.getFirstName() == null || person.getLastName() == null
                || person.getUsername() == null || person.getPassword() == null) {

            throw new IllegalArgumentException("person is not completed!");
        }

        personDao.add(person);
    }

    @Override
    public Person get(final int id) {
        return personDao.get(id);
    }

    @Override
    public void update(final Person person) {
        if (person.getFirstName() == null || person.getLastName() == null
                || person.getUsername() == null || person.getPassword() == null) {

            throw new IllegalArgumentException("person is not completed!");
        }

        personDao.update(person);
    }

    @Override
    public void delete(final int id) {
        personDao.delete(id);
    }

    @Override
    public Person getPersonByCredentials(final String username) {
        if (username == null) {

            throw new IllegalArgumentException("username can't be null!");
        }

        return personDao.getPersonByCredentials(username);

    }
}
