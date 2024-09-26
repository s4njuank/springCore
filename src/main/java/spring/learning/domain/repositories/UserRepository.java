package spring.learning.domain.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import spring.learning.domain.entities.User;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<Integer, User> users;

    public UserRepository(Map<Integer, User> users) {
        this.users = users;
    }

    public void addUser(User user){
        users.put(user.getId(), user);
        System.out.println("user added " + users.get(user.getId()));
    }

    public User getUser(Integer userId){
        return users.get(userId);
    }

    @PostConstruct
    public void loadUsersFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
        InputStream inputStream = getClass().getResourceAsStream("/users.json");

        try {
            // Parse the JSON file into a list of User objects
            List<User> userList = objectMapper.readValue(inputStream, typeReference);
            // Load users into the map
            for (User user : userList) {
                users.put(user.getId(), user);
            }
            System.out.println("Users loaded successfully!");
        } catch (IOException e) {
            System.out.println("Unable to load users: " + e.getMessage());
        }
    }

}
