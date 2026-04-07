package com.julien.score_server.controller;

import com.julien.score_server.dto.ScoreDto;
import com.julien.score_server.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public List<ScoreDto> getAllScores(){
        return scoreService.getAllScores();
    }

    @PostMapping
    public void saveScore(@RequestBody ScoreDto scoreDto) {
        scoreService.saveScore(scoreDto);
    }
}