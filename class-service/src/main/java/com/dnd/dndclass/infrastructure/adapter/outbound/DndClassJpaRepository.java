package com.dnd.dndclass.infrastructure.adapter.outbound;

import com.dnd.dndclass.domain.model.DndClass;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DndClassJpaRepository extends JpaRepository<DndClass, Long> {
    Optional<DndClass> findByName(String name);
}
