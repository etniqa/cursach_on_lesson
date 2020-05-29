package edu.stev.cursach.dao.classes.logOfChangesOfEquipment.repository;

import edu.stev.cursach.model.pojos.LogOfChangesOfEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogOfChangesOfEquipmentRepository extends MongoRepository<LogOfChangesOfEquipment, String> {
}