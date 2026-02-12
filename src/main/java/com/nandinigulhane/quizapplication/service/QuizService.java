package com.nandinigulhane.quizapplication.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.nandinigulhane.quizapplication.model.QuizRequest;
import com.nandinigulhane.quizapplication.model.QuizResponse;
import static com.nandinigulhane.quizapplication.service.Prompts.USER_PROMPT;
import static com.nandinigulhane.quizapplication.service.Prompts.SYSTEM_PROMPT;

@Service
public class QuizService {

    private final ChatClient chatClient;

    public QuizService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public List<QuizResponse> generateQuiz(QuizRequest quizRequest) {
        String topic = quizRequest.getTopic();
        int numberOfQuestions = quizRequest.getNumberOfQuestions();
        String difficulty = quizRequest.getDifficulty();
        boolean explanationNeeded = quizRequest.isExplanationNeeded();

        String userPrompt = USER_PROMPT
                .replace("{{topic}}", topic)
                .replace("{{numberOfQuestions}}", String.valueOf(numberOfQuestions))
                .replace("{{difficulty}}", difficulty)
                .replace("{{explanationNeeded}}", Boolean.toString(explanationNeeded));

        List<QuizResponse> responses = chatClient.prompt(userPrompt)
                .system(SYSTEM_PROMPT)
                .user(userPrompt)
                .call()
                .entity(new ParameterizedTypeReference<List<QuizResponse>>() {
                });

        return responses;

    }
}
