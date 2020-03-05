package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.Equipment;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentApiController implements ICommonApiController<Equipment>{
    @Autowired
    EquipmentServiceImpls equipmentServiceImpls;

    @Override
    public IService getService() {
        return this.equipmentServiceImpls;
    }
}
