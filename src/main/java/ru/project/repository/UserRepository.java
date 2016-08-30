package ru.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.model.entity.UserEntity;

/**
 * Репозиторий доступа к данным пользователей
 * Created by averizhnikov on 25.08.2016.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmailAndPasswordAndActiveTrue(String email, String password);

}
