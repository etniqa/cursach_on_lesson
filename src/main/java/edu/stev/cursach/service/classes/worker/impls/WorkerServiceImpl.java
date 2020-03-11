package edu.stev.cursach.service.classes.worker.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dao.classes.worker.impls.WorkerDaoImplFake;
import edu.stev.cursach.model.pojos.Worker;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements IService<Worker> {
    @Autowired
    WorkerDaoImplFake dao;

    @Override
    public IDao getDao() {
        return dao;
    }

    @Override
    public Worker edit(Worker element) {
        return null;
    }
}
