package spring.learning.domain.repositories;

import spring.learning.domain.entities.Event;
public interface EventRepository {

    public void addEvent(Event ticket);

    public Event getEvent(Integer eventId);

}
