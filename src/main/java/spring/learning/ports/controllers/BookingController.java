package spring.learning.ports.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.learning.domain.entities.Event;
import spring.learning.domain.entities.Ticket;
import spring.learning.domain.entities.User;
import spring.learning.domain.services.EventServiceImpl;
import spring.learning.domain.services.TicketServiceImpl;
import spring.learning.domain.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    private UserServiceImpl userServiceImpl;
    private EventServiceImpl eventServiceImpl;
    private TicketServiceImpl ticketServiceImpl;

    @Autowired
    public void UserController(UserServiceImpl userServiceImpl, EventServiceImpl eventServiceImpl, TicketServiceImpl ticketServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.eventServiceImpl = eventServiceImpl;
        this.ticketServiceImpl = ticketServiceImpl;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userServiceImpl.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> createUser(@PathVariable("id") Integer userId) {
        User user = userServiceImpl.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/event")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        eventServiceImpl.addEvent(event);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable("id") Integer eventId) {
        Event event = eventServiceImpl.getEvent(eventId);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        ticketServiceImpl.addTicket(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer ticketId) {
        Ticket ticket = ticketServiceImpl.getTicket(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

}
