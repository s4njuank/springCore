package spring.learning.domain.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import spring.learning.domain.entities.User;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface UserRepository {

    public void addUser(User user);

    public User getUser(Integer userId);

}
