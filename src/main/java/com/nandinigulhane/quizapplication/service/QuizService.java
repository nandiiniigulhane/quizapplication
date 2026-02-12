package com.nandinigulhane.quizapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.nandinigulhane.quizapplication.model.QuizRequest;
import com.nandinigulhane.quizapplication.model.QuizResponse;

@Service
public class QuizService {

    private final ChatClient chatClient;

    public QuizService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    List<QuizResponse> quizResponses = new ArrayList<>();

    public List<QuizResponse> getQuiz() {
        return quizResponses;
    }

    public void generateQuiz(QuizRequest quizRequest) {
        String topic = quizRequest.getTopic();
        int numberOfQuestions = quizRequest.getNumberOfQuestions();
        String difficulty = quizRequest.getDifficulty();
        quizResponses.clear();

        String promptText = String.format("""
                Generate a quiz on the topic '%s' with %d questions of '%s' difficulty.
                Each question should have 4 options and the correct answer should be indicated.
                Do not include any explanations or additional information, just the questions and answers.
                Return the quiz in a structured format that can be easily parsed, such as JSON or XML.
                Respond only with the quiz content, without any introductory or concluding text.
                JSON should only include the question, options, and correct answer.
                """, topic, numberOfQuestions, difficulty);

        List<QuizResponse> responses = chatClient.prompt(promptText).call()
                .entity(new ParameterizedTypeReference<List<QuizResponse>>() {
                });
        
        quizResponses.addAll(responses);

    }
}
