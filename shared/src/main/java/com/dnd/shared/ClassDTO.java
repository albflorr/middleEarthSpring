package com.dnd.shared;

public class ClassDTO {
    private Long id;
    private String name;
    private String description;
    private int hitDie;
    private String primaryAbility;
    private String savingThrows;
    private String features;

    public ClassDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getHitDie() { return hitDie; }
    public void setHitDie(int hitDie) { this.hitDie = hitDie; }
    public String getPrimaryAbility() { return primaryAbility; }
    public void setPrimaryAbility(String primaryAbility) { this.primaryAbility = primaryAbility; }
    public String getSavingThrows() { return savingThrows; }
    public void setSavingThrows(String savingThrows) { this.savingThrows = savingThrows; }
    public String getFeatures() { return features; }
    public void setFeatures(String features) { this.features = features; }
}
