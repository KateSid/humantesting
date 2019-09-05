package ru.sidorova.humantesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sidorova.humantesting.domain.Answer;
import ru.sidorova.humantesting.domain.Question;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer, String> {
   List<Answer> findByQuestionParent_IdQuestion(long l);
   List<Answer> findAll();
}
