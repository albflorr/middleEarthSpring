package com.dnd.race.application.port.output;

import com.dnd.race.domain.model.Race;
import java.util.List;
import java.util.Optional;

public interface RaceRepository {
    Race save(Race race);
    List<Race> findAll();
    Optional<Race> findById(Long id);
    Optional<Race> findByName(String name);
}
