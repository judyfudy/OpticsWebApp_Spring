package com.bubnii.service.implementations;

import com.bubnii.dao.interfaces.WorkerDao;
import com.bubnii.model.Worker;
import com.bubnii.service.interfaces.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerDao workerDao;

    @Override
    public List<Worker> getAll() {
        return workerDao.getAll();
    }
}
