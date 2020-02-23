package edu.stev.cursach.dao.department.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DepartmentDaoImpl implements IDao<Department> {
    @Autowired
    DataSet dataSet;

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
        return dataSet.getDepartments();
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
