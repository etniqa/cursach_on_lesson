package edu.stev.cursach.service.classes.organization.impls;

import edu.stev.cursach.dao.classes.organization.impls.OrganizationDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.Organization;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrganizationServiceImpl implements IService<Organization> {
    @Autowired
    OrganizationDaoImpl dao;
    @Override
    public IDao getDao() {
        return this.dao;
    }

    @Override
    public Organization edit(Organization element) {
        return null;
    }
    //    @Override
//    public Organization save(Organization element) {
//        return null;
//    }
//
//    @Override
//    public Organization get(String id) {
//        return null;
//    }
//
//    @Override
//    public List<Organization> getAll() {
//        return this.dao.getAll();
//    }
//
//    @Override
//    public Organization edit(Organization element) {
//        return null;
//    }
//
//    @Override
//    public Organization delete(String id) {
//        return dao.delete(id);
//    }
}
