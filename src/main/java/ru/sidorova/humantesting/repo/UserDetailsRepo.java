package ru.sidorova.humantesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sidorova.humantesting.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
