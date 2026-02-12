package com.nandinigulhane.quizapplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nandinigulhane.quizapplication.model.QuizRequest;
import com.nandinigulhane.quizapplication.model.QuizResponse;
import com.nandinigulhane.quizapplication.service.QuizService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Operation(summary = "Generate a quiz based on the provided request")
    @Tag(name = "Quiz Generation", description = "Endpoint for generating quizzes")
    @PostMapping("/generate-quiz")
    public List<QuizResponse> postQuiz(@RequestBody QuizRequest quizRequest) {
        return quizService.generateQuiz(quizRequest);
    }

}
