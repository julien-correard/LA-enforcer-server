package com.julien.score_server.repository;

import com.julien.score_server.model.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {

    List<ScoreEntity> findAllByOrderByScoreDesc();

}