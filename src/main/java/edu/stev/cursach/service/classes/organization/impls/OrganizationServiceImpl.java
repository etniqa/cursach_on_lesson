package edu.stev.cursach.service.classes.organization.impls;

import edu.stev.cursach.dao.classes.organization.impls.OrganizationDaoImpl;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.model.pojos.Organization;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements IService<Organization> {
    @Autowired
    OrganizationDaoImpl dao;

    @Override
    public IDao getDao() {
        return dao;
    }
}
