package spring.learning.ports.controllers.unittests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring.learning.domain.entities.Event;
import spring.learning.domain.entities.Ticket;
import spring.learning.domain.entities.User;
import spring.learning.domain.services.EventServiceImpl;
import spring.learning.domain.services.TicketServiceImpl;
import spring.learning.domain.services.UserServiceImpl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userServiceImpl;

    @MockBean
    private EventServiceImpl eventServiceImpl;

    @MockBean
    private TicketServiceImpl ticketServiceImpl;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;
    private Event event;
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        event = new Event(1, "Spring Boot Conference");
        ticket = new Ticket(1, "VIP Ticket");
        user = new User(1, "John Doe", ticket, event);
    }

    @Test
    public void createUser_shouldReturnCreatedUser() throws Exception {

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.name").value(user.getName()));
    }

    @Test
    public void getUser_shouldReturnUserById() throws Exception {
        when(userServiceImpl.getUser(1)).thenReturn(user);

        mockMvc.perform(get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.name").value(user.getName()));
    }

    @Test
    public void createEvent_shouldReturnCreatedEvent() throws Exception {

        mockMvc.perform(post("/event")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(event)))
                .andExpect(status().isCreated())  // Expect HTTP 201 status
                .andExpect(jsonPath("$.id").value(event.getId()))  // Validate response JSON
                .andExpect(jsonPath("$.name").value(event.getName()));
    }

    @Test
    public void getEvent_shouldReturnEventById() throws Exception {
        when(eventServiceImpl.getEvent(1)).thenReturn(event);

        mockMvc.perform(get("/event/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(event.getId()))
                .andExpect(jsonPath("$.name").value(event.getName()));
    }

    // Test POST /ticket (Create a new Ticket)
    @Test
    public void createTicket_shouldReturnCreatedTicket() throws Exception {
        mockMvc.perform(post("/ticket")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ticket)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(ticket.getId()))
                .andExpect(jsonPath("$.name").value(ticket.getName()));
    }

    @Test
    public void getTicket_shouldReturnTicketById() throws Exception {
        when(ticketServiceImpl.getTicket(1)).thenReturn(ticket);

        mockMvc.perform(get("/ticket/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(ticket.getId()))
                .andExpect(jsonPath("$.name").value(ticket.getName()));
    }
}