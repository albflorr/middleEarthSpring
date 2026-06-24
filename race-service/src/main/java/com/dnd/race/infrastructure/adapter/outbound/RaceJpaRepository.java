package com.dnd.race.infrastructure.adapter.outbound;

import com.dnd.race.domain.model.Race;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceJpaRepository extends JpaRepository<Race, Long> {
    Optional<Race> findByName(String name);
}
