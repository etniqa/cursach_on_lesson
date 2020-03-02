package edu.stev.cursach.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class TechnicianHasEquipment {
    @Id
    private String id;
    private String description;
    private LocalDateTime creationDate;
    private Technician technician;
    private Equipment equipment;

    public TechnicianHasEquipment(String id, String description, LocalDateTime creationDate,
                                  Technician technician, Equipment equipment) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.technician = technician;
        this.equipment = equipment;
    }

    public String getId() {
        return id;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
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
