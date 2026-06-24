package com.dnd.character.infrastructure.adapter.inbound;

import com.dnd.character.application.port.input.CreateCharacterUseCase;
import com.dnd.character.application.port.input.GetCharacterUseCase;
import com.dnd.shared.CharacterDTO;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
public class CharacterRestController {

    private final CreateCharacterUseCase createCharacterUseCase;
    private final GetCharacterUseCase getCharacterUseCase;

    public CharacterRestController(CreateCharacterUseCase createCharacterUseCase,
                                    GetCharacterUseCase getCharacterUseCase) {
        this.createCharacterUseCase = createCharacterUseCase;
        this.getCharacterUseCase = getCharacterUseCase;
    }

    @PostMapping
    public CharacterDTO createCharacter(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String race = request.get("race");
        String className = request.get("className");
        String method = request.getOrDefault("method", "standard");
        return createCharacterUseCase.createCharacter(name, race, className, method);
    }

    @GetMapping
    public List<CharacterDTO> getAllCharacters() {
        return getCharacterUseCase.getAllCharacters();
    }

    @GetMapping("/{id}")
    public CharacterDTO getCharacterById(@PathVariable Long id) {
        return getCharacterUseCase.getCharacterById(id);
    }
}
