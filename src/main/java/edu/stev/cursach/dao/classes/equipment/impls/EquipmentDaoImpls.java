package edu.stev.cursach.dao.classes.equipment.impls;

import edu.stev.cursach.dao.classes.equipment.repository.EquipmentRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.classes.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EquipmentDaoImpls implements IDao<Equipment> {
    @Autowired
    DataSet dataSet;

    @Autowired
    EquipmentRepository repository;

    @PostConstruct
    void init(){
        repository.deleteAll();
        this.repository.saveAll(this.dataSet.getEquipments());
    }

    @Override
    public MongoRepository getRepository() {
        return repository;
    }
}
