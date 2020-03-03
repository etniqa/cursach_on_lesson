package edu.stev.cursach.service.classes.department.impls;

import edu.stev.cursach.dao.classes.department.impls.DepartmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.Department;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements IService<Department> {
    @Autowired
    DepartmentDaoImpl dao;

    @Override
    public IDao getDao() {
        return this.dao;
    }

    @Override
    public Department edit(Department element) {
        return null;
    }
}
