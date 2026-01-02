package org.yildirimog.flightturk.mapper;

import org.mapstruct.Mapper;
import org.yildirimog.flightturk.dto.request.PassengerRequestDTO;
import org.yildirimog.flightturk.dto.response.PassengerResponseDTO;
import org.yildirimog.flightturk.entity.Passenger;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    Passenger toEntity(PassengerRequestDTO requestDTO);
    PassengerResponseDTO toResponseDto(Passenger passenger);
    List<PassengerResponseDTO> toResponseDtoList(List<Passenger> passengers);
}
