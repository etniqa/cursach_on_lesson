package edu.stev.cursach.form;

public class TechnicianHasEquipmentForm {
    private String name;
    private String description;

    private String technicianId;
    private String equipmentId;

    public TechnicianHasEquipmentForm(String name, String description, String technicianId, String equipmentId) {
        this.name = name;
        this.description = description;
        this.technicianId = technicianId;
        this.equipmentId = equipmentId;
    }

    public TechnicianHasEquipmentForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }
}
