package com.dnd.shared;

public class CharacterDTO {
    private Long id;
    private String name;
    private String raceName;
    private String className;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int level;
    private String background;

    public CharacterDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRaceName() { return raceName; }
    public void setRaceName(String raceName) { this.raceName = raceName; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }
    public int getDexterity() { return dexterity; }
    public void setDexterity(int dexterity) { this.dexterity = dexterity; }
    public int getConstitution() { return constitution; }
    public void setConstitution(int constitution) { this.constitution = constitution; }
    public int getIntelligence() { return intelligence; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public int getWisdom() { return wisdom; }
    public void setWisdom(int wisdom) { this.wisdom = wisdom; }
    public int getCharisma() { return charisma; }
    public void setCharisma(int charisma) { this.charisma = charisma; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public String getBackground() { return background; }
    public void setBackground(String background) { this.background = background; }
}
