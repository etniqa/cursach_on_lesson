package edu.stev.cursach.dao.classes.organization.impls;

import edu.stev.cursach.dao.classes.organization.repository.OrganizationRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.classes.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OrganizationDaoImpl implements IDao<Organization> {
    @Autowired
    DataSet dataSet;

    @Autowired
    OrganizationRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        this.repository.saveAll(this.dataSet.getOrganizations());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
