package spring.learning.ports.controllers.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring.learning.domain.entities.Event;
import spring.learning.domain.entities.Ticket;
import spring.learning.domain.entities.User;
import spring.learning.domain.services.EventService;
import spring.learning.domain.services.TicketService;
import spring.learning.domain.services.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerFullIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;

    private User user;
    private Event event;
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        // Initialize entities before each test
        event = new Event(1, "Spring Boot Conference");
        eventService.addEvent(event);

        ticket = new Ticket(1, "VIP Ticket");
        ticketService.addTicket(ticket);

        user = new User(1, "John Doe", ticket, event);
        userService.addUser(user);
    }
    @Test
    public void createUser_shouldReturnCreatedUser() throws Exception {
        User newUser = new User(2, "Jane Doe", ticket, event);

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(newUser.getId()))
                .andExpect(jsonPath("$.name").value(newUser.getName()));
    }

    @Test
    public void getUser_shouldReturnUserById() throws Exception {
        mockMvc.perform(get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.name").value(user.getName()));
    }

    @Test
    public void createEvent_shouldReturnCreatedEvent() throws Exception {
        Event newEvent = new Event(2, "Java Conference");

        mockMvc.perform(post("/event")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newEvent)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(newEvent.getId()))
                .andExpect(jsonPath("$.name").value(newEvent.getName()));
    }

    @Test
    public void getEvent_shouldReturnEventById() throws Exception {
        mockMvc.perform(get("/event/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(event.getId()))
                .andExpect(jsonPath("$.name").value(event.getName()));
    }

    @Test
    public void createTicket_shouldReturnCreatedTicket() throws Exception {
        Ticket newTicket = new Ticket(2, "Standard Ticket");

        mockMvc.perform(post("/ticket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newTicket)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(newTicket.getId()))
                .andExpect(jsonPath("$.name").value(newTicket.getName()));
    }

    @Test
    public void getTicket_shouldReturnTicketById() throws Exception {
        mockMvc.perform(get("/ticket/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(ticket.getId()))
                .andExpect(jsonPath("$.name").value(ticket.getName()));
    }
}