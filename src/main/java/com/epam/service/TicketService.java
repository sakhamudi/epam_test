package com.epam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.domain.Tickets;
import com.epam.repo.TicketRepositary;

@Service
public class TicketService {

	@Autowired
	TicketRepositary ticketRepositary;

	public List<Tickets> getAllTickets() {
		return ticketRepositary.findAll();
	}

	public Optional<Tickets> getTicketById(Long id) {
		return ticketRepositary.findById(id);
	}

	public Tickets createOrUpdateTicket(Tickets ticket) {
		Optional<Tickets> optticket = ticketRepositary.findById(ticket.getId());
		if (optticket.isPresent()) {
			Tickets newEntity = optticket.get();
			newEntity.setName(ticket.getName());
			newEntity.setMessages(ticket.getMessages());
			ticketRepositary.save(newEntity);
			return newEntity;
		} else {
			ticket = ticketRepositary.save(ticket);
			return ticket;
		}
	}

	public void deleteTicketById(Long id) throws Exception {

		Optional<Tickets> tickets = ticketRepositary.findById(id);
		if (tickets.isPresent()) {
			ticketRepositary.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}

	}
}
