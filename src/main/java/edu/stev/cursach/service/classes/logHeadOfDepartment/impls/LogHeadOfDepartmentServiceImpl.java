package edu.stev.cursach.service.classes.logHeadOfDepartment.impls;

import edu.stev.cursach.dao.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.LogHeadOfDepartment;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogHeadOfDepartmentServiceImpl implements IService<LogHeadOfDepartment> {
    @Autowired
    LogHeadOfDepartmentDaoImpl dao;
    @Override
    public IDao getDao() {
        return this.dao;
    }
//    @Override
//    public LogHeadOfDepartment save(LogHeadOfDepartment element) {
//        return null;
//    }
//
//    @Override
//    public LogHeadOfDepartment get(String id) {
//        return null;
//    }
//
//    @Override
//    public List<LogHeadOfDepartment> getAll() {
//        return dao.getAll();
//    }
//
//    @Override
//    public LogHeadOfDepartment edit(LogHeadOfDepartment element) {
//        return null;
//    }
//
//    @Override
//    public LogHeadOfDepartment delete(String id) {
//        return dao.delete(id);
//    }

    @Override
    public LogHeadOfDepartment edit(LogHeadOfDepartment element) {
        return null;
    }
}
