package com.epam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.domain.Tickets;
import com.epam.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping
	public ResponseEntity<List<Tickets>> getAllTickets() {
		List<Tickets> list = ticketService.getAllTickets();
		return new ResponseEntity<List<Tickets>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tickets> getTicketById(@PathVariable("id") Long id) throws Exception {
		Optional<Tickets> optTicket = ticketService.getTicketById(id);
		if (optTicket.isPresent()) {
			return new ResponseEntity<Tickets>(optTicket.get(), new HttpHeaders(), HttpStatus.OK);
		} else {
			throw new Exception("Id not found");
		}
	}

	@PostMapping
	public ResponseEntity<Tickets> createOrUpdateTicket(Tickets ticket) throws Exception {
		Tickets updated = ticketService.createOrUpdateTicket(ticket);
		return new ResponseEntity<Tickets>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteTicketById(@PathVariable("id") Long id) throws Exception {
		ticketService.deleteTicketById(id);
		return HttpStatus.FORBIDDEN;
	}
}
