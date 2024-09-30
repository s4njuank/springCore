package spring.learning.domain.repositories;

import spring.learning.domain.entities.Ticket;

public interface TicketRepository {

    public void addTicket(Ticket ticket);

    public Ticket getTicket(Integer ticketId);

}
