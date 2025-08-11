package com.example.demo.repository;

import com.example.demo.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GameRepositroy extends JpaRepository<Game, String> {

    List<Game> findByTitleContainingIgnoreCase(String title);

}
