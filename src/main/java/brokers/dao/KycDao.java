package brokers.dao;

import brokers.entity.Kyc;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KycDao extends MongoRepository<Kyc, ObjectId> {
}
