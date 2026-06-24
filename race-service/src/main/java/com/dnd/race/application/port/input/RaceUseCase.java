package com.dnd.race.application.port.input;

import com.dnd.shared.RaceDTO;
import java.util.List;

public interface RaceUseCase {
    RaceDTO createRace(RaceDTO raceDTO);
    List<RaceDTO> getAllRaces();
    RaceDTO getRaceByName(String name);
    RaceDTO getRaceById(Long id);
}
