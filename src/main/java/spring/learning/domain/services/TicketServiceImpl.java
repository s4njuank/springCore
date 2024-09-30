package spring.learning.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.learning.domain.entities.Ticket;
import spring.learning.ports.controllers.repositories.TicketRepositoryImpl;

@Service
public class TicketServiceImpl {

    private TicketRepositoryImpl ticketRepositoryImpl;

    @Autowired
    public TicketServiceImpl(TicketRepositoryImpl ticketRepositoryImpl) {
        this.ticketRepositoryImpl = ticketRepositoryImpl;
    }

    public void addTicket(Ticket ticket){
        System.out.println("adding ticket " + ticket.getName());
        ticketRepositoryImpl.addTicket(ticket);
    }

    public Ticket getTicket(Integer ticketId){
        System.out.println("Getting ticket " + ticketId);
        return ticketRepositoryImpl.getTicket(ticketId);
    }

}
