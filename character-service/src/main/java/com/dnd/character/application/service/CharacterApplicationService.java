package com.dnd.character.application.service;

import com.dnd.character.application.port.input.CreateCharacterUseCase;
import com.dnd.character.application.port.input.GetCharacterUseCase;
import com.dnd.character.application.port.output.CharacterRepository;
import com.dnd.character.application.port.output.ClassServicePort;
import com.dnd.character.application.port.output.RaceServicePort;
import com.dnd.character.domain.model.Abilities;
import com.dnd.character.domain.model.DnDCharacter;
import com.dnd.character.domain.service.AbilityGenerator;
import com.dnd.shared.CharacterDTO;
import com.dnd.shared.ClassDTO;
import com.dnd.shared.RaceDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharacterApplicationService implements CreateCharacterUseCase, GetCharacterUseCase {

    private final CharacterRepository characterRepository;
    private final RaceServicePort raceServicePort;
    private final ClassServicePort classServicePort;
    private final AbilityGenerator abilityGenerator;

    public CharacterApplicationService(CharacterRepository characterRepository,
                                        RaceServicePort raceServicePort,
                                        ClassServicePort classServicePort,
                                        AbilityGenerator abilityGenerator) {
        this.characterRepository = characterRepository;
        this.raceServicePort = raceServicePort;
        this.classServicePort = classServicePort;
        this.abilityGenerator = abilityGenerator;
    }

    @Override
    @Transactional
    public CharacterDTO createCharacter(String name, String raceName, String className, String method) {
        RaceDTO race = raceServicePort.getRaceByName(raceName);
        ClassDTO dndClass = classServicePort.getClassByName(className);

        Abilities abilities;
        if ("rolled".equalsIgnoreCase(method)) {
            abilities = abilityGenerator.generateRolled();
        } else {
            abilities = abilityGenerator.generateStandardArray();
        }

        DnDCharacter character = new DnDCharacter(name, raceName, className, abilities);
        character.applyRacialBonuses(
                race.getStrengthBonus(), race.getDexterityBonus(),
                race.getConstitutionBonus(), race.getIntelligenceBonus(),
                race.getWisdomBonus(), race.getCharismaBonus()
        );

        DnDCharacter saved = characterRepository.save(character);
        return toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CharacterDTO> getAllCharacters() {
        return characterRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CharacterDTO getCharacterById(Long id) {
        return characterRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Character not found with id: " + id));
    }

    private CharacterDTO toDTO(DnDCharacter c) {
        CharacterDTO dto = new CharacterDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setRaceName(c.getRaceName());
        dto.setClassName(c.getClassName());
        dto.setLevel(c.getLevel());
        dto.setBackground(c.getBackground());
        dto.setStrength(c.getAbilities().getStrength());
        dto.setDexterity(c.getAbilities().getDexterity());
        dto.setConstitution(c.getAbilities().getConstitution());
        dto.setIntelligence(c.getAbilities().getIntelligence());
        dto.setWisdom(c.getAbilities().getWisdom());
        dto.setCharisma(c.getAbilities().getCharisma());
        return dto;
    }
}
