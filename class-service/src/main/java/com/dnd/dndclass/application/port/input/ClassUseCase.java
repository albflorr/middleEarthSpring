package com.dnd.dndclass.application.port.input;

import com.dnd.shared.ClassDTO;
import java.util.List;

public interface ClassUseCase {
    ClassDTO createClass(ClassDTO classDTO);
    List<ClassDTO> getAllClasses();
    ClassDTO getClassByName(String name);
    ClassDTO getClassById(Long id);
}
