package brokers.dao;

import brokers.entity.Brokerage;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerageDao extends MongoRepository<Brokerage,ObjectId> {

}
