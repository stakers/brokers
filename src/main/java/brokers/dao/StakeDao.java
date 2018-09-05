package brokers.dao;

import brokers.entity.Stake;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeDao extends MongoRepository<Stake, ObjectId> {

}
