package brokers.dao;

import brokers.entity.MutualFund;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutualFundDao extends MongoRepository<MutualFund, ObjectId> {
}
