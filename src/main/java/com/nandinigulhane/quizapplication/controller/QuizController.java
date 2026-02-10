package com.nandinigulhane.quizapplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nandinigulhane.quizapplication.model.QuizRequest;
import com.nandinigulhane.quizapplication.model.QuizResponse;
import com.nandinigulhane.quizapplication.service.QuizService;


@RestController
@RequestMapping("/")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/quiz")
    public void postQuiz(@RequestBody QuizRequest quizRequest){
        quizService.generateQuiz(quizRequest);
    }

    @GetMapping("/quiz")
    public List<QuizResponse> getQuiz(){
        return quizService.getQuiz();
    } 

}
