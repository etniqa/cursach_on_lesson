package edu.stev.cursach.service.classes.logChiefOfTypeOfProject.impls;

import edu.stev.cursach.dao.classes.logChiefOfTypeOfProject.impls.LogChiefOfTypeOfProjectDaoImpl;
import edu.stev.cursach.model.LogChiefOfTypeOfProject;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogChiefOfTypeOfProjectServiceImpl implements IService<LogChiefOfTypeOfProject> {
    @Autowired
    LogChiefOfTypeOfProjectDaoImpl dao;

    @Override
    public LogChiefOfTypeOfProject save(LogChiefOfTypeOfProject element) {
        return null;
    }

    @Override
    public LogChiefOfTypeOfProject get(String id) {
        return null;
    }

    @Override
    public List<LogChiefOfTypeOfProject> getAll() {
        return dao.getAll();
    }

    @Override
    public LogChiefOfTypeOfProject edit(LogChiefOfTypeOfProject element) {
        return null;
    }

    @Override
    public LogChiefOfTypeOfProject delete(LogChiefOfTypeOfProject element) {
        return null;
    }
}