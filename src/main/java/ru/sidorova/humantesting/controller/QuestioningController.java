package ru.sidorova.humantesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sidorova.humantesting.domain.Answer;
import ru.sidorova.humantesting.domain.Question;
import ru.sidorova.humantesting.repo.AnswerRepo;
import ru.sidorova.humantesting.repo.QuestionRepo;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestioningController {
    @Autowired
    private  QuestionRepo questionRepo;
    @Autowired
    private AnswerRepo answerRepo;

    @GetMapping
    public List<Answer> list(){
        return answerRepo.findByQuestionParent_IdQuestion((long)1);
    }
}
