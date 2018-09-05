package brokers.dao;

import brokers.entity.Profile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDao extends MongoRepository<Profile, ObjectId> {

}
