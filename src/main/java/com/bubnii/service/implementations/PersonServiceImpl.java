package com.bubnii.service.implementations;

import com.bubnii.dao.interfaces.PersonDao;
import com.bubnii.model.Person;
import com.bubnii.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public void add(Person person) {
        if (person.getFirstName() == null || person.getLastName() == null
                || person.getUsername() == null || person.getPassword() == null) {

            throw new IllegalArgumentException("person is not completed!");
        }

        personDao.add(person);
    }

    @Override
    public Person get(int id)  {
        return personDao.get(id);
    }

    @Override
    public void update(Person person)  {
        if (person.getFirstName() == null || person.getLastName() == null
                || person.getUsername() == null || person.getPassword() == null) {

            throw new IllegalArgumentException("person is not completed!");
        }

        personDao.update(person);
    }

    @Override
    public void delete(int id)  {
        personDao.delete(id);
    }

    @Override
    public Person getPersonByCredentials(String username)  {
        if (username == null) {

            throw new IllegalArgumentException("username can't be null!");
        }

        return personDao.getPersonByCredentials(username);

    }
}
