package com.study.train.controller;

import com.study.train.domain.Ticket;
import com.study.train.domain.Users;
import com.study.train.exceptions.ConflictException;
import com.study.train.repo.TicketRepo;
import com.study.train.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UsersController {
    private final UsersRepo usersRepo;
    private final TicketRepo ticketRepo;

    @Autowired
    public UsersController(UsersRepo usersRepo, TicketRepo ticketRepo) {
        this.usersRepo = usersRepo;
        this.ticketRepo = ticketRepo;
    }

    @GetMapping("{id}/tickets")
    public List<Ticket> getUserTickets(@PathVariable Long id) {
        Optional<Users> userFormDb = usersRepo.findById(id);
        List<Ticket> tickets = new ArrayList<Ticket>();
        userFormDb.ifPresent(user -> tickets.addAll(user.getTickets()));
        return tickets;
    }

    @PostMapping("{id}/buyTicket")
    public Optional<Users> buyTicket(@PathVariable Long id, @RequestBody Ticket body) {
        if (body == null || body.getCityFrom() == null || body.getCityTo() == null || body.getPrice() == null) {
            throw new ConflictException("Города и цена - обязательные поля");
        }

        Ticket newTicket = ticketRepo.save(body);

        Optional<Users> userFormDb = usersRepo.findById(id);

        if (userFormDb.isEmpty()) {
            throw new ConflictException("Пользователь не найден");
        }

        userFormDb.ifPresent(user -> {
            List<Ticket> oldTickets = user.getTickets();
            oldTickets.add(newTicket);
            user.setTickets(oldTickets);

            usersRepo.save(user);
        });

        return userFormDb;
    }

    @DeleteMapping("{id}/tickets/{ticketId}")
    public void deleteTicket(@PathVariable Long id, @PathVariable Long ticketId) {
        Optional<Users> userFormDb = usersRepo.findById(id);
        userFormDb.ifPresent(user -> {
            List<Ticket> filteredTickets = user.getTickets().stream().filter(ticket -> !Objects.equals(ticket.getId(), ticketId)).collect(Collectors.toList());
            user.setTickets(filteredTickets);
            usersRepo.save(user);
        });
    }
}
