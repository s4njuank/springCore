package spring.learning.ports.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.learning.domain.entities.Event;
import spring.learning.domain.entities.Ticket;
import spring.learning.domain.entities.User;
import spring.learning.domain.services.EventService;
import spring.learning.domain.services.TicketService;
import spring.learning.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    private UserService userService;
    private EventService eventService;
    private TicketService ticketService;

    @Autowired
    public void UserController(UserService userService, EventService eventService, TicketService ticketService) {
        this.userService = userService;
        this.eventService = eventService;
        this.ticketService = ticketService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> createUser(@PathVariable("id") Integer userId) {
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/event")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        eventService.addEvent(event);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable("id") Integer eventId) {
        Event event = eventService.getEvent(eventId);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer ticketId) {
        Ticket ticket = ticketService.getTicket(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

}
