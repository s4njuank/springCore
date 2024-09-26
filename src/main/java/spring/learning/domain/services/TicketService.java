package spring.learning.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.learning.domain.entities.Ticket;
import spring.learning.domain.entities.User;
import spring.learning.domain.repositories.TicketRepository;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void addTicket(Ticket ticket){
        System.out.println("adding ticket " + ticket.getName());
        ticketRepository.addTicket(ticket);
    }

    public Ticket getTicket(Integer ticketId){
        System.out.println("Getting ticket " + ticketId);
        return ticketRepository.getTicket(ticketId);
    }

}
