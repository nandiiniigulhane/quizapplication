package com.nandinigulhane.quizapplication.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {
    private String question;

    private List<String> options;

    private String answer;
}
