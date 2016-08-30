package ru.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.project.model.entity.AuthEntity;

import java.util.Date;
import java.util.List;

/**
 * Репозиторий доступа к данным авторизации
 * Created by averizhnikov on 25.08.2016.
 */
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

    @Query("SELECT a " +
           "  FROM AuthEntity a " +
           " WHERE a.tokenExpirationDate >= :date")
    List<AuthEntity> findActiveTokens(@Param("date") Date date);

}
