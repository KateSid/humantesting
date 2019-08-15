package ru.sidorova.humantesting.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import ru.sidorova.humantesting.domain.Questionnaire;
import ru.sidorova.humantesting.domain.Views;
import ru.sidorova.humantesting.repo.QuestionnaireRepo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("questionnaire")
public class QuestionnaireController {
    private final QuestionnaireRepo questionnaireRepo;
    public QuestionnaireController(QuestionnaireRepo questionnaireRepo) {
        this.questionnaireRepo = questionnaireRepo;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Questionnaire> list(){
        return questionnaireRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullQuestionnaire.class)
    public Questionnaire getOne(@PathVariable("id") Questionnaire questionnaire){
        return questionnaire;
    }
    @PostMapping
    public Questionnaire create(@RequestBody Questionnaire questionnaire){
        questionnaire.setCreationDate(LocalDateTime.now());
        return questionnaireRepo.save(questionnaire);
    }
    @PutMapping("{id}")
    public Questionnaire update(
            @PathVariable("id") Questionnaire questFromDb,
            @RequestBody Questionnaire questionnaire){
        BeanUtils.copyProperties(questionnaire, questFromDb,"id");

        return questionnaireRepo.save(questFromDb);
    }
    @DeleteMapping ("{id}")
    public void delete(@PathVariable("id") Questionnaire questionnaire){
        questionnaireRepo.delete(questionnaire);
    }
}
