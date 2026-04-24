package com.careerblueprint.model;

public class DailyMission {
    private int day;
    private String phase; // PEMBERSIHAN, INSTALASI, LAUNCH
    private String title;
    private String mainTask;
    private String sideQuest; // Elemen menyenangkan
    private String reward; // Badge atau poin
    private String quote; // Motivasi quote
    private boolean completed;
    private String bonusDay; // For special days like rest days

    public DailyMission() {}

    public DailyMission(int day, String phase, String title, String mainTask, String sideQuest, String reward) {
        this.day = day;
        this.phase = phase;
        this.title = title;
        this.mainTask = mainTask;
        this.sideQuest = sideQuest;
        this.reward = reward;
    }

    public DailyMission(int day, String phase, String title, String mainTask, String sideQuest, String reward, String quote) {
        this.day = day;
        this.phase = phase;
        this.title = title;
        this.mainTask = mainTask;
        this.sideQuest = sideQuest;
        this.reward = reward;
        this.quote = quote;
    }

    public DailyMission(int day, String phase, String title, String mainTask, String sideQuest, String reward, String quote, String bonusDay) {
        this.day = day;
        this.phase = phase;
        this.title = title;
        this.mainTask = mainTask;
        this.sideQuest = sideQuest;
        this.reward = reward;
        this.quote = quote;
        this.bonusDay = bonusDay;
    }

    // Getters and Setters
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainTask() {
        return mainTask;
    }

    public void setMainTask(String mainTask) {
        this.mainTask = mainTask;
    }

    public String getSideQuest() {
        return sideQuest;
    }

    public void setSideQuest(String sideQuest) {
        this.sideQuest = sideQuest;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getBonusDay() {
        return bonusDay;
    }

    public void setBonusDay(String bonusDay) {
        this.bonusDay = bonusDay;
    }
}
