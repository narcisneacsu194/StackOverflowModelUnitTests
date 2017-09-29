package com.teamtreehouse.techdegree.overboard.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Question extends Post {
    private List<Answer> answers;

    public Question(User author, String text) {
        super(author, text);
        answers = new ArrayList<>();
    }

    protected void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return Collections.unmodifiableList(answers);
    }


}
