package com.dnd.character.domain.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
public class DnDCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String raceName;
    private String className;
    private int level;
    private String background;

    @Embedded
    private Abilities abilities;

    public DnDCharacter() {}

    public DnDCharacter(String name, String raceName, String className, Abilities abilities) {
        this.name = name;
        this.raceName = raceName;
        this.className = className;
        this.abilities = abilities;
        this.level = 1;
        this.background = "Acolyte";
    }

    public void applyRacialBonuses(int strBonus, int dexBonus, int conBonus,
                                    int intBonus, int wisBonus, int chaBonus) {
        abilities.setStrength(abilities.getStrength() + strBonus);
        abilities.setDexterity(abilities.getDexterity() + dexBonus);
        abilities.setConstitution(abilities.getConstitution() + conBonus);
        abilities.setIntelligence(abilities.getIntelligence() + intBonus);
        abilities.setWisdom(abilities.getWisdom() + wisBonus);
        abilities.setCharisma(abilities.getCharisma() + chaBonus);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRaceName() { return raceName; }
    public void setRaceName(String raceName) { this.raceName = raceName; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public String getBackground() { return background; }
    public void setBackground(String background) { this.background = background; }
    public Abilities getAbilities() { return abilities; }
    public void setAbilities(Abilities abilities) { this.abilities = abilities; }
}
