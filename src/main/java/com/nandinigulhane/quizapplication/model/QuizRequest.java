package com.nandinigulhane.quizapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizRequest {
    private String topic;

    private int numberOfQuestions;

    private String difficulty;

    private boolean explanationNeeded;

}
