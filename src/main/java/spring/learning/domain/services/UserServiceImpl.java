package spring.learning.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.learning.domain.entities.User;
import spring.learning.ports.controllers.repositories.UserRepositoryImpl;

@Service
public class UserServiceImpl {

    private UserRepositoryImpl userRepositoryImpl;

    @Autowired
    public UserServiceImpl(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public void addUser(User user){
        System.out.println("Adding User " + user.getName());
        userRepositoryImpl.addUser(user);
    }

    public User getUser(Integer userId){
        System.out.println("Getting User " + userId);
        return userRepositoryImpl.getUser(userId);
    }

}
