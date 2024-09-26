package spring.learning.domain.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import spring.learning.domain.entities.Ticket;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Repository
public class TicketRepository {

    private Map<Integer, Ticket> tickets;

    public TicketRepository(Map<Integer, Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        tickets.put(ticket.getId(), ticket);
        System.out.println("user added " + tickets.get(ticket.getId()));
    }

    public Ticket getTicket(Integer ticketId){
        return tickets.get(ticketId);
    }

    @PostConstruct
    public void loadTicketsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ticket>> typeReference = new TypeReference<List<Ticket>>() {};
        InputStream inputStream = getClass().getResourceAsStream("/tickets.json");

        try {
            // Parse the JSON file into a list of Ticket objects
            List<Ticket> ticketList = objectMapper.readValue(inputStream, typeReference);
            // Load tickets into the map
            for (Ticket ticket : ticketList) {
                tickets.put(ticket.getId(), ticket);
            }
            System.out.println("Tickets loaded successfully!");
        } catch (IOException e) {
            System.out.println("Unable to load tickets: " + e.getMessage());
        }
    }

}
