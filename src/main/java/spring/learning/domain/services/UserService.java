package spring.learning.domain.services;

import org.springframework.stereotype.Service;
import spring.learning.domain.entities.User;

@Service
public class UserService {

    public void addUser(User user){
        System.out.println("adding User " + user.getName());
    }

}
