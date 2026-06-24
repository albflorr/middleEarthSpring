package com.dnd.shared;

public class RaceDTO {
    private Long id;
    private String name;
    private String description;
    private int strengthBonus;
    private int dexterityBonus;
    private int constitutionBonus;
    private int intelligenceBonus;
    private int wisdomBonus;
    private int charismaBonus;
    private String traits;

    public RaceDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getStrengthBonus() { return strengthBonus; }
    public void setStrengthBonus(int strengthBonus) { this.strengthBonus = strengthBonus; }
    public int getDexterityBonus() { return dexterityBonus; }
    public void setDexterityBonus(int dexterityBonus) { this.dexterityBonus = dexterityBonus; }
    public int getConstitutionBonus() { return constitutionBonus; }
    public void setConstitutionBonus(int constitutionBonus) { this.constitutionBonus = constitutionBonus; }
    public int getIntelligenceBonus() { return intelligenceBonus; }
    public void setIntelligenceBonus(int intelligenceBonus) { this.intelligenceBonus = intelligenceBonus; }
    public int getWisdomBonus() { return wisdomBonus; }
    public void setWisdomBonus(int wisdomBonus) { this.wisdomBonus = wisdomBonus; }
    public int getCharismaBonus() { return charismaBonus; }
    public void setCharismaBonus(int charismaBonus) { this.charismaBonus = charismaBonus; }
    public String getTraits() { return traits; }
    public void setTraits(String traits) { this.traits = traits; }
}
