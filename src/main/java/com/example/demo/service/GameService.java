package com.example.demo.service;

import com.example.demo.domain.Game;
import com.example.demo.exception.NoSuchEntityException;
import com.example.demo.repository.GameRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private GameRepositroy gameRepositroy;

    public List<Game> getAllGames() {
        return gameRepositroy.findAll();
    }

    public List<Game> searchByTitle(String title) {
        return gameRepositroy.findByTitleContainingIgnoreCase(title);
    }

    public Game save(Game game)  {
       return gameRepositroy.save(game);
    }

    public Game edit(Game game) {
        return gameRepositroy.save(game);
    }

    public Game findBiId(UUID id) {
        Optional<Game> optionalGame = gameRepositroy.findById(id);
        if (optionalGame.isPresent()) {
            return optionalGame.get();
        } else {
            throw new NoSuchEntityException("There was no game with id: " +id);
        }
    }

    public void deleteById(UUID id) {
        gameRepositroy.deleteById(id);
    }

}
