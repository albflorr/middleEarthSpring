package com.dnd.character.application.port.output;

import com.dnd.shared.ClassDTO;

public interface ClassServicePort {
    ClassDTO getClassByName(String name);
}
