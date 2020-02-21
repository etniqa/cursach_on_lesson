package edu.stev.cursach.dao.worker.impls;

import edu.stev.cursach.dao.worker.interfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class WorkerDaoImplFake implements IDao<Worker> {
    @Autowired
    DataSet dataSet;

    @Override
    public Worker save(Worker element) {
        return null;
    }

    @Override
    public Worker get(String id) {
        return null;
    }

    @Override
    public List getAll() {
        return this.dataSet.getWorkerList();
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
