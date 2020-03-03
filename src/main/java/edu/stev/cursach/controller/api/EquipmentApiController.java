package edu.stev.cursach.controller.api;

import edu.stev.cursach.model.classes.Equipment;
import edu.stev.cursach.service.classes.equipment.impls.EquipmentServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentApiController {
    @Autowired
    EquipmentServiceImpls equipmentServiceImpls;

    @RequestMapping("/get/list")
    public List<Equipment> getAll(){
        return this.equipmentServiceImpls.getAll();
    }
}
