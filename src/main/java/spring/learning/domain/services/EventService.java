package spring.learning.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.learning.domain.entities.Event;
import spring.learning.domain.entities.Ticket;
import spring.learning.domain.repositories.EventRepository;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void addEvent(Event event){
        System.out.println("adding Event " + event.getName());
        eventRepository.addEvent(event);
    }

    public Event getEvent(Integer eventId){
        System.out.println("Getting Event " + eventId);
        return eventRepository.getEvent(eventId);
    }

}
