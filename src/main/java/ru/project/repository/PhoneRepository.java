package ru.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.model.entity.Phone;

/**
 * Created by user on 30.09.16.
 */
public interface PhoneRepository extends JpaRepository<Phone, Integer> {



}
