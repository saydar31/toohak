package ru.itis.kahootflux.controllers;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Game;
import ru.itis.kahootflux.dto.PlayerResponse;
import ru.itis.kahootflux.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public Mono<Game> startGame(@RequestParam String quizId){
        return gameService.start(quizId);
    }

    @PostMapping("/{id}/enroll")
    public Mono<PlayerResponse> enroll(@PathVariable String id, @RequestParam String name){
        return gameService.enroll(id, name);
    }


}
