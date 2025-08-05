package com.example.demo.controller;

import com.example.demo.domain.Game;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping()
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/search")
    public List<Game> searchGames(@RequestParam("q") String query) {
        return gameService.searchByTitle(query);
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable UUID id) {
        return gameService.findBiId(id);
    }

    @PostMapping("/create")
    public Game createGame(@RequestBody Game game) {
        return gameService.save(game);
    }

    @PostMapping("/update")
    public Game updateGame(@RequestBody Game game) {
        return gameService.edit(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGameById(@PathVariable UUID id) {
        gameService.deleteById(id);
    }

}
