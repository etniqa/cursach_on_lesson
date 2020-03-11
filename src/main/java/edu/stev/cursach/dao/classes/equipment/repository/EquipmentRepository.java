package edu.stev.cursach.dao.classes.equipment.repository;

import edu.stev.cursach.model.pojos.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipmentRepository extends MongoRepository<Equipment, String> {
}
