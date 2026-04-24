package com.careerblueprint.model;

import java.util.List;

public class Identity {
    private String title;
    private String description;
    private List<String> monetizationPaths;
    private List<String> matchedSkills;
    private List<String> matchedCategories;

    public Identity() {}

    public Identity(String title, String description, List<String> monetizationPaths) {
        this.title = title;
        this.description = description;
        this.monetizationPaths = monetizationPaths;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMonetizationPaths() {
        return monetizationPaths;
    }

    public void setMonetizationPaths(List<String> monetizationPaths) {
        this.monetizationPaths = monetizationPaths;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public List<String> getMatchedCategories() {
        return matchedCategories;
    }

    public void setMatchedCategories(List<String> matchedCategories) {
        this.matchedCategories = matchedCategories;
    }
}
