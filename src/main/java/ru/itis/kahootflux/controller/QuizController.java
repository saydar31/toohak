package ru.itis.kahootflux.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Quiz;
import ru.itis.kahootflux.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public Flux<Quiz> getQuizzes(){
        return quizService.getQuizzes();
    }

    @GetMapping("/{id}")
    public Mono<Quiz> getQuiz(@PathVariable long id){
        return quizService.getQuiz(id);
    }

    @PostMapping
    public Mono<Quiz> saveQuiz(@RequestBody Quiz quiz){
        return quizService.saveQuiz(quiz);
    }

    @PutMapping("/{id}")
    public Mono<Quiz> updateQuiz(@PathVariable long id, Quiz quiz){
        return quizService.update(id, quiz);
    }
}
