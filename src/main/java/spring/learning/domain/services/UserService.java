package spring.learning.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.learning.domain.entities.User;
import spring.learning.domain.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        System.out.println("Adding User " + user.getName());
        userRepository.addUser(user);
    }

    public User getUser(Integer userId){
        System.out.println("Getting User " + userId);
        return userRepository.getUser(userId);
    }

}
