package edu.stev.cursach.service.classes.logHeadOfDepartment.impls;

import edu.stev.cursach.dao.classes.logHeadOfDepartment.impls.LogHeadOfDepartmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.LogHeadOfDepartment;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogHeadOfDepartmentServiceImpl implements IService<LogHeadOfDepartment> {
    @Autowired
    LogHeadOfDepartmentDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }

    public LogHeadOfDepartment removeFromHead(String canLeadIdWhichRemoving){
        return dao.removeFromHead(canLeadIdWhichRemoving);
    }
}
