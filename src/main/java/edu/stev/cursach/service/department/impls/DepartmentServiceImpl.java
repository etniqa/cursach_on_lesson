package edu.stev.cursach.service.department.impls;

import edu.stev.cursach.dao.classes.department.impls.DepartmentDaoImpl;
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
    public Department save(Department element) {
        return null;
    }

    @Override
    public Department get(String id) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        return dao.getAll();
    }

    @Override
    public Department edit(Department element) {
        return null;
    }

    @Override
    public Department delete(Department element) {
        return null;
    }
}
