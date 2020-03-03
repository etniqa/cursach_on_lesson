package edu.stev.cursach.dataSet.impls;

import edu.stev.cursach.dataSet.cmnInterfaces.IDataSet;
import edu.stev.cursach.dataSet.mainDataSet.DataSet;
import edu.stev.cursach.model.classes.TypeOfAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeOfAgreementDataSet implements IDataSet<TypeOfAgreement> {
    @Autowired
    DataSet dataSet;

    @Override
    public List<TypeOfAgreement> getList() {
        return dataSet.getTypeOfAgreements();
    }
}
