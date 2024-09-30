package spring.learning.domain.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    private Integer id;
    private String name;
    private Ticket ticket;
    private Event event;

    public User() {
    }

    public User(Integer id, String name, Ticket ticket, Event event) {
        this.id = id;
        this.name = name;
        this.ticket = ticket;
        this.event = event;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Event getEvent() {
        return event;
    }

    @Autowired
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    @Autowired
    public void setEvent(Event event) {
        this.event = event;
    }
}
