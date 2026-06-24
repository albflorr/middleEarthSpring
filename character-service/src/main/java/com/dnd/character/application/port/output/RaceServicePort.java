package com.dnd.character.application.port.output;

import com.dnd.shared.RaceDTO;

public interface RaceServicePort {
    RaceDTO getRaceByName(String name);
}
