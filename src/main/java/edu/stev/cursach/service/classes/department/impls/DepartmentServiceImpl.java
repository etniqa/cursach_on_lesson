package edu.stev.cursach.service.classes.department.impls;

import edu.stev.cursach.dao.classes.department.impls.DepartmentDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.classes.Department;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//    @Override
//    public Department save(Department element) {
//        return null;
//    }
//
//    @Override
//    public Department get(String id) {
//        return null;
//    }
//
//    @Override
//    public List<Department> getAll() {
//        return dao.getAll();
//    }
//
//    @Override
//    public Department edit(Department element) {
//        return null;
//    }
//
//    @Override
//    public Department delete(String id) {
//        return null;
//    }

}
