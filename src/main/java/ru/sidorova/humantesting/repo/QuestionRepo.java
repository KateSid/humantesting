package ru.sidorova.humantesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sidorova.humantesting.domain.Question;

public interface QuestionRepo extends JpaRepository<Question, String> {
}
