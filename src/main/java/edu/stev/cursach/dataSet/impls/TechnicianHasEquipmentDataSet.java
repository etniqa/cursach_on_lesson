package edu.stev.cursach.dataSet.impls;

import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.classes.TechnicianHasEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechnicianHasEquipmentDataSet implements IDataSet<TechnicianHasEquipment> {
    @Autowired
    DataSet dataSet;

    @Override
    public List<TechnicianHasEquipment> getList() {
        return dataSet.getTechnicianHasEquipmentsList();
    }
}
