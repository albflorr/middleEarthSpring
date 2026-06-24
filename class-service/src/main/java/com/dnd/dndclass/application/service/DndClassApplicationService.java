package com.dnd.dndclass.application.service;

import com.dnd.dndclass.application.port.input.ClassUseCase;
import com.dnd.dndclass.application.port.output.ClassRepository;
import com.dnd.dndclass.domain.model.ClassFeature;
import com.dnd.dndclass.domain.model.DndClass;
import com.dnd.shared.ClassDTO;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DndClassApplicationService implements ClassUseCase {

    private final ClassRepository classRepository;

    public DndClassApplicationService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    @Transactional
    public ClassDTO createClass(ClassDTO dto) {
        DndClass dndClass = new DndClass(
                dto.getName(), dto.getDescription(), dto.getHitDie(),
                dto.getPrimaryAbility(), dto.getSavingThrows(),
                Collections.emptyList()
        );
        DndClass saved = classRepository.save(dndClass);
        return toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClassDTO> getAllClasses() {
        return classRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClassDTO getClassByName(String name) {
        return classRepository.findByName(name)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Class not found: " + name));
    }

    @Override
    @Transactional(readOnly = true)
    public ClassDTO getClassById(Long id) {
        return classRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + id));
    }

    private ClassDTO toDTO(DndClass c) {
        ClassDTO dto = new ClassDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setDescription(c.getDescription());
        dto.setHitDie(c.getHitDie());
        dto.setPrimaryAbility(c.getPrimaryAbility());
        dto.setSavingThrows(c.getSavingThrows());
        dto.setFeatures(c.getFeatures().stream()
                .map(ClassFeature::getFeatureName)
                .collect(Collectors.joining(", ")));
        return dto;
    }
}
