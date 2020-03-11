package edu.stev.cursach.dao.classes.technicianHasEquipment.impls;

import edu.stev.cursach.dao.classes.technicianHasEquipment.repository.TechnicianHasEquipmentRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.pojos.TechnicianHasEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TechnicianHasEquipmentDaoImpl implements IDao<TechnicianHasEquipment> {
    @Autowired
    DataSet dataSet;

    @Autowired
    TechnicianHasEquipmentRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        this.repository.saveAll(this.dataSet.getTechnicianHasEquipmentsList());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
