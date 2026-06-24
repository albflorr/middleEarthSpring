package com.dnd.race.application.service;

import com.dnd.race.application.port.input.RaceUseCase;
import com.dnd.race.application.port.output.RaceRepository;
import com.dnd.race.domain.model.AbilityScoreIncrease;
import com.dnd.race.domain.model.Race;
import com.dnd.shared.RaceDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RaceApplicationService implements RaceUseCase {

    private final RaceRepository raceRepository;

    public RaceApplicationService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    @Transactional
    public RaceDTO createRace(RaceDTO dto) {
        AbilityScoreIncrease asi = new AbilityScoreIncrease(
                dto.getStrengthBonus(), dto.getDexterityBonus(),
                dto.getConstitutionBonus(), dto.getIntelligenceBonus(),
                dto.getWisdomBonus(), dto.getCharismaBonus()
        );
        Race race = new Race(dto.getName(), dto.getDescription(),
                asi, dto.getTraits(), "Common", 30);
        Race saved = raceRepository.save(race);
        return toDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RaceDTO> getAllRaces() {
        return raceRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public RaceDTO getRaceByName(String name) {
        return raceRepository.findByName(name)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Race not found: " + name));
    }

    @Override
    @Transactional(readOnly = true)
    public RaceDTO getRaceById(Long id) {
        return raceRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Race not found with id: " + id));
    }

    private RaceDTO toDTO(Race r) {
        RaceDTO dto = new RaceDTO();
        dto.setId(r.getId());
        dto.setName(r.getName());
        dto.setDescription(r.getDescription());
        dto.setStrengthBonus(r.getAbilityScoreIncrease().getStrength());
        dto.setDexterityBonus(r.getAbilityScoreIncrease().getDexterity());
        dto.setConstitutionBonus(r.getAbilityScoreIncrease().getConstitution());
        dto.setIntelligenceBonus(r.getAbilityScoreIncrease().getIntelligence());
        dto.setWisdomBonus(r.getAbilityScoreIncrease().getWisdom());
        dto.setCharismaBonus(r.getAbilityScoreIncrease().getCharisma());
        dto.setTraits(r.getTraits());
        return dto;
    }
}
