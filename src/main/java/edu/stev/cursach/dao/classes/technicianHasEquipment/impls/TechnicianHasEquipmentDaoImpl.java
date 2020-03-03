package edu.stev.cursach.dao.classes.technicianHasEquipment.impls;

import edu.stev.cursach.dao.classes.technicianHasEquipment.repository.TechnicianHasEquipmentRepository;
import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.Department;
import edu.stev.cursach.model.TechnicianHasEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
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
    public TechnicianHasEquipment save(TechnicianHasEquipment element) {
        return null;
    }

    @Override
    public TechnicianHasEquipment get(String id) {
        return null;
    }

    @Override
    public List<TechnicianHasEquipment> getAll() {
        return this.dataSet.getTechnicianHasEquipmentsList();
    }

    @Override
    public TechnicianHasEquipment edit(String id, TechnicianHasEquipment newElem) {
        return null;
    }

    @Override
    public TechnicianHasEquipment delete(String id) {
        TechnicianHasEquipment whichNeedToDelete = this.get(id);
        this.dataSet.getTechnicianHasEquipmentsList().remove(this.get(id));
        return whichNeedToDelete;
    }
}
