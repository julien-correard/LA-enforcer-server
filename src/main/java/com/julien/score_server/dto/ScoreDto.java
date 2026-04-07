package com.julien.score_server.dto;

import java.time.LocalDate;

public class ScoreDto {

    private int score;
    private LocalDate date;
    private String playerName;
    private String gameVersion;

    public ScoreDto(){}

    public ScoreDto(int score, LocalDate date, String playerName, String gameVersion) {
        this.score = score;
        this.date = date;
        this.playerName = playerName;
        this.gameVersion = gameVersion;
    }

    // ✅ Getters

    public int getScore() {
        return score;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    // ✅ Setters

    public void setScore(int score) {
        this.score = score;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }
}


