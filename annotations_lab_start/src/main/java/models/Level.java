package models;

public enum Level {

    BENG("BENG"),
    BSC("BSC"),
    BA("BA"),
    PHD("Ph.D");

    private String level;

    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
