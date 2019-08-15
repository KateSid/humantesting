package ru.sidorova.humantesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sidorova.humantesting.domain.Questionnaire;

public interface QuestionnaireRepo extends JpaRepository<Questionnaire,Long> {
}
