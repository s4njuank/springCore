package spring.learning.domain.services;

import org.springframework.stereotype.Service;
import spring.learning.domain.entities.Ticket;

@Service
public class TicketService {

    public void addTicket(Ticket ticket){
        System.out.println("adding ticket " + ticket.getName());
    }

}
