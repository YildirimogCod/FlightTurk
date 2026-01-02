package org.yildirimog.flightturk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yildirimog.flightturk.dto.request.PassengerRequestDTO;
import org.yildirimog.flightturk.dto.response.PassengerResponseDTO;
import org.yildirimog.flightturk.entity.Passenger;
import org.yildirimog.flightturk.service.PassengerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passenger")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;
    @PostMapping
    public ResponseEntity<PassengerResponseDTO> create(@RequestBody PassengerRequestDTO requestDTO){
     return ResponseEntity.status(HttpStatus.CREATED).body(passengerService.createPassenger(requestDTO));
    }
    @GetMapping
    public ResponseEntity<List<PassengerResponseDTO>> getAll(){
        return ResponseEntity.ok(passengerService.listAll());
    }
}
