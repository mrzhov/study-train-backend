package com.study.train.controller;

import com.study.train.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.study.train.constants.Constants.CITIES;

@RestController
@RequestMapping("tickets")
public class TicketsController {
    private final TicketRepo ticketRepo;

    @Autowired
    public TicketsController(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @GetMapping("/getCities")
    public List<Map<String, String>> citiesList() {
        return CITIES;
    }
}
