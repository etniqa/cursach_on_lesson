package edu.stev.cursach.dao.group.repository;

import edu.stev.cursach.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
