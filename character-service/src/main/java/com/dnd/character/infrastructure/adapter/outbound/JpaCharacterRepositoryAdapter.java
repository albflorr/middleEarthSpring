package com.dnd.character.infrastructure.adapter.outbound;

import com.dnd.character.application.port.output.CharacterRepository;
import com.dnd.character.domain.model.DnDCharacter;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class JpaCharacterRepositoryAdapter implements CharacterRepository {

    private final CharacterJpaRepository jpaRepository;

    public JpaCharacterRepositoryAdapter(CharacterJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public DnDCharacter save(DnDCharacter character) {
        return jpaRepository.save(character);
    }

    @Override
    public List<DnDCharacter> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<DnDCharacter> findById(Long id) {
        return jpaRepository.findById(id);
    }
}
