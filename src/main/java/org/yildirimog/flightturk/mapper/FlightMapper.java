package org.yildirimog.flightturk.mapper;

import org.mapstruct.Mapper;
import org.yildirimog.flightturk.dto.request.FlightRequestDTO;
import org.yildirimog.flightturk.dto.response.FlightResponseDTO;
import org.yildirimog.flightturk.entity.Flight;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {
  Flight toEntity(FlightRequestDTO requestDTO);
  FlightResponseDTO toResponseDto(Flight flight);
  List<FlightResponseDTO> toResponseDtoList(List<Flight> flight);
}
