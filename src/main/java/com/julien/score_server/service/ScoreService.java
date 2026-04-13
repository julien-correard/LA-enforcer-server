package com.julien.score_server.service;

import com.julien.score_server.dto.ScoreDto;
import com.julien.score_server.model.ScoreEntity;
import com.julien.score_server.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    //  cache
    private List<ScoreDto> cache;
    private long lastUpdate = 0;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<ScoreDto> getAllScores() {
        long now = System.currentTimeMillis();

        //  refresh toutes les 30 secondes
        if (cache == null || (now - lastUpdate > 30000)) {

            cache = scoreRepository.findAllByOrderByScoreDesc().stream()
                    .map(entity -> new ScoreDto(
                            entity.getScore(),
                            entity.getDate(),
                            entity.getPlayerName(),
                            entity.getGameVersion()
                    ))
                    .collect(Collectors.toList());

            lastUpdate = now;
        }

        return cache;
    }

    public void saveScore(ScoreDto scoreDto) {
        ScoreEntity entity = new ScoreEntity(
            scoreDto.getScore(),
            scoreDto.getDate(),
            scoreDto.getPlayerName(),
            scoreDto.getGameVersion()
        );

        scoreRepository.save(entity);

        //  IMPORTANT : invalider le cache
        cache = null;
    }
}