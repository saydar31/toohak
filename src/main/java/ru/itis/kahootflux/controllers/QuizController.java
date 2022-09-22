package ru.itis.kahootflux.controllers;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.service.QuizService;
import ru.itis.kahootflux.data.Quiz;
import ru.itis.kahootflux.dto.QuizDto;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public Mono<Quiz> createQuiz(@RequestBody QuizDto quizRequest) {
        return quizService.createQuiz(quizRequest);
    }

    @PutMapping
    public Mono<Quiz> updateQuiz(Quiz quiz) {
        return quizService.update(quiz);
    }

    @GetMapping("/{id}")
    public Mono<Quiz> getById(@PathVariable String id){
        return quizService.find(id);
    }

    @GetMapping
    public Flux<Quiz> getAll(){
        return quizService.getAll();
    }


}
