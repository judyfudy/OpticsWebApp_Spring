package com.bubnii.service.implementations;

import com.bubnii.dao.interfaces.WorkerDao;
import com.bubnii.model.Worker;
import com.bubnii.service.interfaces.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

    private WorkerDao workerDao;

    public WorkerServiceImpl(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Override
    public List<Worker> getAll() {
        return workerDao.getAll();
    }
}
