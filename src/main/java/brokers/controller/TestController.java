package brokers.controller;

import brokers.entity.User;
import brokers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    UserService userService;
    @GetMapping("/getuser")
    public List<User> getDomain(){

        return userService.fetchUser();
    }
    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }
}
