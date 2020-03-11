package edu.stev.cursach.controller.api.controllers;

import edu.stev.cursach.controller.api.cmnInterface.ICommonApiController;
import edu.stev.cursach.model.pojos.Equipment;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import edu.stev.cursach.service.cmnInterfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentApiController implements ICommonApiController<Equipment> {
    @Autowired
    EquipmentServiceImpls equipmentServiceImpls;

    @Override
    public IService getService() {
        return this.equipmentServiceImpls;
    }
}
