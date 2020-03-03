package edu.stev.cursach.service.classes.worker.impls;

import edu.stev.cursach.service.classes.worker.interfaces.IService;
import edu.stev.cursach.dao.classes.worker.impls.WorkerDaoImplFake;
import edu.stev.cursach.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkerServiceImpl implements IService<Worker> {
    @Autowired
    WorkerDaoImplFake dao;

    @Override
    public Worker save(Worker element) {
        return null;
    }

    @Override
    public Worker get(String is) {
        return null;
    }

    @Override
    public List<Worker> getAll() {
        return this.dao.getAll();
    }

    @Override
    public Worker edit(Worker element) {
        return null;
    }

    @Override
    public Worker delete(Worker element) {
        return null;
    }
}