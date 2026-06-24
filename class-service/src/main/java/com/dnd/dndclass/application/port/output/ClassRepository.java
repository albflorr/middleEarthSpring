package com.dnd.dndclass.application.port.output;

import com.dnd.dndclass.domain.model.DndClass;
import java.util.List;
import java.util.Optional;

public interface ClassRepository {
    DndClass save(DndClass dndClass);
    List<DndClass> findAll();
    Optional<DndClass> findById(Long id);
    Optional<DndClass> findByName(String name);
}
