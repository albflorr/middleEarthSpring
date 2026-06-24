package com.dnd.dndclass.domain.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "dnd_classes")
public class DndClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int hitDie;
    private String primaryAbility;
    private String savingThrows;

    @ElementCollection
    private List<ClassFeature> features;

    public DndClass() {}

    public DndClass(String name, String description, int hitDie,
                    String primaryAbility, String savingThrows, List<ClassFeature> features) {
        this.name = name;
        this.description = description;
        this.hitDie = hitDie;
        this.primaryAbility = primaryAbility;
        this.savingThrows = savingThrows;
        this.features = features;
    }

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
    public List<ClassFeature> getFeatures() { return features; }
    public void setFeatures(List<ClassFeature> features) { this.features = features; }
}
