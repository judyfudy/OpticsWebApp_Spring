package com.bubnii.dao.implementations;

import com.bubnii.dao.interfaces.WorkerDao;
import com.bubnii.model.Worker;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorkerDaoImpl implements WorkerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Worker> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Worker").list();
    }

    @Override
    public void add(Worker worker) {
        sessionFactory.getCurrentSession().persist(worker);
    }

    @Override
    public Worker get(int id) {
        return sessionFactory.getCurrentSession().get(Worker.class, id);
    }

    @Override
    public void update(Worker worker) {
        sessionFactory.getCurrentSession().update(worker);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().remove(id);
    }
}
