package edu.stev.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TechnicianHasEquipment {
    @Id
    private String id;
    private Technician technician;
    private Equipment equipment;

    public TechnicianHasEquipment(String id, Technician technician, Equipment equipment) {
        this.id = id;
        this.technician = technician;
        this.equipment = equipment;
    }

    public String getId() {
        return id;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
