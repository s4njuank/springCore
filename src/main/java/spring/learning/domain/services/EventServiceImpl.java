package spring.learning.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.learning.domain.entities.Event;
import spring.learning.ports.controllers.repositories.EventRepositoryImpl;

@Service
public class EventServiceImpl {

    private EventRepositoryImpl eventRepositoryImpl;

    @Autowired
    public EventServiceImpl(EventRepositoryImpl eventRepositoryImpl) {
        this.eventRepositoryImpl = eventRepositoryImpl;
    }

    public void addEvent(Event event){
        System.out.println("adding Event " + event.getName());
        eventRepositoryImpl.addEvent(event);
    }

    public Event getEvent(Integer eventId){
        System.out.println("Getting Event " + eventId);
        return eventRepositoryImpl.getEvent(eventId);
    }

}
