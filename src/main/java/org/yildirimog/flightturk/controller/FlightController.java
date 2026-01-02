package org.yildirimog.flightturk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yildirimog.flightturk.dto.request.FlightRequestDTO;
import org.yildirimog.flightturk.dto.response.FlightResponseDTO;
import org.yildirimog.flightturk.service.FlightService;

@RestController
@RequestMapping("/api/v1/flight")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;
    @PostMapping
    public ResponseEntity<FlightResponseDTO> create(@RequestBody FlightRequestDTO requestDTO){
     return ResponseEntity.status(HttpStatus.CREATED).body(flightService.createFlight(requestDTO));
    }
}
