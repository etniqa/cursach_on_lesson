package edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls;

import edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.LogChiefOfTypeOfProject;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogChiefOfTypeOfProjectServiceImpl implements IService<LogChiefOfTypeOfProject> {
    @Autowired
    LogChiefOfTypeOfProjectDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }

    @Override
    public LogChiefOfTypeOfProject edit(LogChiefOfTypeOfProject element) {
        return null;
    }
}
