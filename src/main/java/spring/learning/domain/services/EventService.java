package spring.learning.domain.services;

import org.springframework.stereotype.Service;
import spring.learning.domain.entities.Event;

@Service
public class EventService {

    public void addEvent(Event event){
        System.out.println("adding Event " + event.getName());
    }

}
