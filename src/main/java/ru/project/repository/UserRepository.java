package ru.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.model.entity.User;

/**
 * Репозиторий доступа к данным пользователей
 * Created by averizhnikov on 25.08.2016.
 */
public interface UserRepository extends JpaRepository<User, Integer> {



}
