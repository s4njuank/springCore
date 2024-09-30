package spring.learning.ports.controllers.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.learning.domain.entities.Event;
import spring.learning.domain.repositories.EventRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private Map<Integer, Event> events;

    @Autowired
    public EventRepositoryImpl(Map<Integer, Event> events) {
        this.events = events;
    }

    public void addEvent(Event ticket){
        events.put(ticket.getId(), ticket);
        System.out.println("user added " + events.get(ticket.getId()));
    }

    public Event getEvent(Integer eventId){
        return events.get(eventId);
    }

    @PostConstruct
    public void loadEventsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Event>> typeReference = new TypeReference<List<Event>>() {};
        InputStream inputStream = getClass().getResourceAsStream("/events.json");

        try {
            List<Event> eventList = objectMapper.readValue(inputStream, typeReference);
            for (Event event : eventList) {
                events.put(event.getId(), event);
            }
            System.out.println("Events loaded successfully!");
        } catch (IOException e) {
            System.out.println("Unable to load events: " + e.getMessage());
        }
    }

}
