package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.epam.domain.Tickets;

public interface TicketRepositary extends JpaRepository<Tickets, Long> {

}