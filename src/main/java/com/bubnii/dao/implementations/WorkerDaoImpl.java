package com.bubnii.dao.implementations;

import com.bubnii.dao.interfaces.WorkerDao;
import com.bubnii.model.Worker;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerDaoImpl implements WorkerDao {

    private SessionFactory sessionFactory;

    public WorkerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Worker> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Worker").list();
    }

    @Override
    public void add(final Worker worker) {
        sessionFactory.getCurrentSession().persist(worker);
    }

    @Override
    public Worker get(final int id) {
        return sessionFactory.getCurrentSession().get(Worker.class, id);
    }

    @Override
    public void update(final Worker worker) {
        sessionFactory.getCurrentSession().update(worker);
    }

    @Override
    public void delete(final int id) {
        sessionFactory.getCurrentSession().remove(id);
    }
}
