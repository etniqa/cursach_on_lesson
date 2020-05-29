package edu.stev.cursach.dao.classes.logOfChangesOfWorker.repository;

import edu.stev.cursach.model.pojos.LogOfChangesOfWorker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogOfChangesOfWorkerRepository extends MongoRepository<LogOfChangesOfWorker, String> {
}
