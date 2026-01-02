package org.yildirimog.flightturk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yildirimog.flightturk.dto.request.TicketRequestDto;
import org.yildirimog.flightturk.dto.response.TicketResponseDTO;
import org.yildirimog.flightturk.repository.TicketRepository;
import org.yildirimog.flightturk.service.TicketService;

@RestController
@RequestMapping("/api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketResponseDTO> create(@RequestBody TicketRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.buyTicket(requestDto));
    }
}
