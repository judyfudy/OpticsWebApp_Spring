package com.bubnii.dao.implementations;

import com.bubnii.dao.interfaces.PersonDao;
import com.bubnii.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Person getPersonByCredentials(String username)  {
        Query<Person> query = sessionFactory.getCurrentSession()
                .createQuery("from Person where username=:username")
                .setParameter("username", username);

        List<Person> personList = query.list();
        Person person = null;

        if (!personList.isEmpty()) {
            person = personList.get(0);
        }
        return person;
    }

    @Override
    public List<Person> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    public void add(Person person)  {
        sessionFactory.getCurrentSession().persist(person);
    }

    @Override
    public Person get(int id)  {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Override
    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public void delete(int id)  {
        sessionFactory.getCurrentSession().remove(id);
    }
}
