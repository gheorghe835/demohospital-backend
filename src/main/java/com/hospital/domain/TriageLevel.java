package com.hospital.domain;

public enum TriageLevel {

    RED(1, "Critic", "#F44336"), //roșu intens
    ORANGE(2, "Urgent", "#FF9800"), // portocaliu
    YELLOW(3, "Semi-urgent", "#FFC107"), // galben-auriu
    GREEN(4, "Nebolnav", "#4CAF50"), // verde
    BLUE(5, "Neurgent", "#2196F3"); //albastru

    private final int level;
    private final String description;
    private final String color;

    TriageLevel(int level, String description, String color) {
        this.level = level;
        this.description = description;
        this.color = color;
    }

    public int getLevel() { return level; }
    public String getDescription() { return description; }
    public String getColor() { return color; }

    public static TriageLevel fromScore(int score) {
        if (score >= 15) return RED;
        if (score >= 10) return ORANGE;
        if (score >= 6) return YELLOW;
        if (score >= 3) return GREEN;
        return BLUE;
    }
}
