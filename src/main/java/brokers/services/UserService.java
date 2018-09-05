package brokers.services;

import brokers.dao.UserDao;
import brokers.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserDao userDao;
    public List<User> fetchUser() {
        return userDao.findAll();
    }

    public User save(User user) {
        return userDao.save(user);
    }
}
