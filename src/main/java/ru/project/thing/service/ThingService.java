package ru.project.thing.service;


import ru.project.thing.exception.ThingExistException;
import ru.project.thing.exception.ThingNotFoundException;
import ru.project.thing.model.dto.ThingDTO;

public interface ThingService {

    ThingDTO get(Long thingId) throws ThingNotFoundException;

    void delete(Long thingId);

    ThingDTO add(ThingDTO thingDTO) throws ThingExistException;

    ThingDTO update(ThingDTO thingDTO) throws ThingNotFoundException;
}
