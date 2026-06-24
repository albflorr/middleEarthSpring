package com.dnd.race.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Embedded
    private AbilityScoreIncrease abilityScoreIncrease;

    private String traits;
    private String languages;
    private int speed;

    public Race() {}

    public Race(String name, String description, AbilityScoreIncrease asi,
                String traits, String languages, int speed) {
        this.name = name;
        this.description = description;
        this.abilityScoreIncrease = asi;
        this.traits = traits;
        this.languages = languages;
        this.speed = speed;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public AbilityScoreIncrease getAbilityScoreIncrease() { return abilityScoreIncrease; }
    public void setAbilityScoreIncrease(AbilityScoreIncrease asi) { this.abilityScoreIncrease = asi; }
    public String getTraits() { return traits; }
    public void setTraits(String traits) { this.traits = traits; }
    public String getLanguages() { return languages; }
    public void setLanguages(String languages) { this.languages = languages; }
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }
}
