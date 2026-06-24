package com.dnd.dndclass.infrastructure.adapter.inbound;

import com.dnd.dndclass.application.port.input.ClassUseCase;
import com.dnd.shared.ClassDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/classes")
public class ClassRestController {

    private final ClassUseCase classUseCase;

    public ClassRestController(ClassUseCase classUseCase) {
        this.classUseCase = classUseCase;
    }

    @PostMapping
    public ClassDTO createClass(@RequestBody ClassDTO classDTO) {
        return classUseCase.createClass(classDTO);
    }

    @GetMapping
    public List<ClassDTO> getAllClasses() {
        return classUseCase.getAllClasses();
    }

    @GetMapping("/{id}")
    public ClassDTO getClassById(@PathVariable Long id) {
        return classUseCase.getClassById(id);
    }

    @GetMapping("/name/{name}")
    public ClassDTO getClassByName(@PathVariable String name) {
        return classUseCase.getClassByName(name);
    }
}
