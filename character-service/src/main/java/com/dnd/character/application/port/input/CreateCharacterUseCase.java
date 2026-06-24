package com.dnd.character.application.port.input;

import com.dnd.shared.CharacterDTO;

public interface CreateCharacterUseCase {
    CharacterDTO createCharacter(String name, String raceName, String className, String method);
}
