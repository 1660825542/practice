package com.rock.dao;

import com.rock.entities.Question;

import java.util.List;

public interface IQuestionDao {
    List<Question> allQuestions();
}
