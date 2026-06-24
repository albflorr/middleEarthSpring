package com.dnd.race.infrastructure.adapter.outbound;

import com.dnd.race.application.port.output.RaceRepository;
import com.dnd.race.domain.model.Race;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class JpaRaceRepositoryAdapter implements RaceRepository {

    private final RaceJpaRepository jpaRepository;

    public JpaRaceRepositoryAdapter(RaceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Race save(Race race) {
        return jpaRepository.save(race);
    }

    @Override
    public List<Race> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Race> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Optional<Race> findByName(String name) {
        return jpaRepository.findByName(name);
    }
}
