package edu.stev.cursach.dao.classes.technicianHasEquipment.repository;

import edu.stev.cursach.model.TechnicianHasEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TechnicianHasEquipmentRepository extends MongoRepository<TechnicianHasEquipment, String> {
}
