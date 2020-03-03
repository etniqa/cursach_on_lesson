package edu.stev.cursach.dao.classes.equipment.impls;

import edu.stev.cursach.dao.classes.equipment.repository.EquipmentRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.impls.EquipmentDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.classes.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
public class EquipmentDaoImpls implements IDao<Equipment> {
    @Autowired
    EquipmentDataSet dataSet;

    @Override
    public IDataSet getDataSet() {
        return this.dataSet;
    }
    //    @PostConstruct
//    void init(){
//        repository.deleteAll();
//        this.repository.saveAll(this.dataSet.getEquipments());
//    }

    /*@Override
    public Equipment save(Equipment element) {
        return null;
    }

    @Override
    public Equipment get(String id) {
        return null;
    }

    @Override
    public List<Equipment> getAll() {
        return dataSet.getEquipments();
    }

    @Override
    public Equipment edit(String id, Equipment newElem) {
        return null;
    }

    @Override
    public Equipment delete(String id) {
        Equipment whichNeedToDelete = this.get(id);
        this.dataSet.getEquipments().remove(this.get(id));
        return whichNeedToDelete;
    }*/
}
