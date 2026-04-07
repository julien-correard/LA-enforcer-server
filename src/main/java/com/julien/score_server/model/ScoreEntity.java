package com.julien.score_server.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "scores")
public class ScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    private LocalDate date;

    private String playerName;

    private String gameVersion;

    // ✅ Constructeur vide obligatoire pour JPA
    public ScoreEntity() {
    }

    // ✅ Constructeur principal
    public ScoreEntity(int score, LocalDate date, String playerName, String gameVersion) {
        this.score = score;
        this.date = date;
        this.playerName = playerName;
        this.gameVersion = gameVersion;
    }

    // ✅ Getters

    public Long getId() {
        return id;
    }

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

    // ✅ Setters (recommandé pour JPA)

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