package edu.stev.cursach.dao.equipment.impls;

import edu.stev.cursach.dao.cmnInterfaces.IDao;
import edu.stev.cursach.dataSet.DataSet;
import edu.stev.cursach.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EquipmentDaoImpls implements IDao<Equipment> {
    @Autowired
    DataSet dataSet;

    @Override
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
    public Equipment edit(Equipment element) {
        return null;
    }

    @Override
    public Equipment delete(Equipment element) {
        return null;
    }
}
