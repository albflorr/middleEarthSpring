package com.dnd.dndclass.domain.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class ClassFeature {
    private String featureName;
    private String featureDescription;
    private int levelRequired;

    public ClassFeature() {}

    public ClassFeature(String featureName, String featureDescription, int levelRequired) {
        this.featureName = featureName;
        this.featureDescription = featureDescription;
        this.levelRequired = levelRequired;
    }

    public String getFeatureName() { return featureName; }
    public void setFeatureName(String featureName) { this.featureName = featureName; }
    public String getFeatureDescription() { return featureDescription; }
    public void setFeatureDescription(String featureDescription) { this.featureDescription = featureDescription; }
    public int getLevelRequired() { return levelRequired; }
    public void setLevelRequired(int levelRequired) { this.levelRequired = levelRequired; }
}
