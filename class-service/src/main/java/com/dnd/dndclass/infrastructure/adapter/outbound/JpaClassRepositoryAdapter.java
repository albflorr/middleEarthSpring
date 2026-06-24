package com.dnd.dndclass.infrastructure.adapter.outbound;

import com.dnd.dndclass.application.port.output.ClassRepository;
import com.dnd.dndclass.domain.model.DndClass;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class JpaClassRepositoryAdapter implements ClassRepository {

    private final DndClassJpaRepository jpaRepository;

    public JpaClassRepositoryAdapter(DndClassJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public DndClass save(DndClass dndClass) {
        return jpaRepository.save(dndClass);
    }

    @Override
    public List<DndClass> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<DndClass> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Optional<DndClass> findByName(String name) {
        return jpaRepository.findByName(name);
    }
}
