package edu.stev.cursach.model;

public class TechnicianHasEquipment {
    private int id;
    private Technician technician;
    private Equipment equipment;

    public TechnicianHasEquipment(Technician technician, Equipment equipment) {
        this.technician = technician;
        this.equipment = equipment;
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
