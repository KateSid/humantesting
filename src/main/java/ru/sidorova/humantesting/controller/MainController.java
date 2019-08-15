package ru.sidorova.humantesting.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sidorova.humantesting.domain.User;
import ru.sidorova.humantesting.repo.QuestionnaireRepo;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final QuestionnaireRepo questionnaireRepo;

    public MainController(QuestionnaireRepo questionnaireRepo) {
        this.questionnaireRepo = questionnaireRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user){
        HashMap<Object,Object> data=new HashMap<>();
        data.put("profile",user);
        data.put("questionnaires",questionnaireRepo.findAll());
        model.addAttribute("frontendData",data);
        return "index";
    }
}
