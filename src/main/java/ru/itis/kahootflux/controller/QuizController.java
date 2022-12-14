package ru.itis.kahootflux.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.itis.kahootflux.data.Game;
import ru.itis.kahootflux.data.Question;
import ru.itis.kahootflux.data.Quiz;
import ru.itis.kahootflux.dto.QuestionRequest;
import ru.itis.kahootflux.service.GameService;
import ru.itis.kahootflux.service.QuestionService;
import ru.itis.kahootflux.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;
    private final QuestionService questionService;
    private final GameService gameService;

    public QuizController(QuizService quizService, QuestionService questionService, GameService gameService) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.gameService = gameService;
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

    @GetMapping("/{id}")
    public Flux<Question> getQuestions(@PathVariable long id){
        return questionService.getQuestions(id);
    }

    @PutMapping("/{id}/questions")
    public Flux<Question> setQuestions(@PathVariable long id, List<QuestionRequest> questions){
        return questionService.setQuestions(id, questions);
    }

    @PutMapping("/{id}/start-game")
    public Mono<Game> startGame(@PathVariable long id){
        return gameService.startByQuizId(id);
    }
}
