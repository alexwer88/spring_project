package ru.project.thing.service.impl;

import ru.project.thing.exception.ThingExistException;
import ru.project.thing.exception.ThingNotFoundException;
import ru.project.thing.model.dto.ThingDTO;
import ru.project.thing.model.entity.ThingEntity;
import ru.project.thing.repository.ThingRepository;
import ru.project.thing.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThingServiceImpl implements ThingService {

    @Autowired
    private ThingRepository thingRepository;

    @Override
    public ThingDTO get(Long thingId) throws ThingNotFoundException {
        ThingEntity thingEntity = thingRepository.find(thingId);
        if (thingEntity == null)
            throw new ThingNotFoundException("thing.id = " + thingId);

        return new ThingDTO(
                thingEntity.getId(),
                thingEntity.getName(),
                thingEntity.getDescription(),
                thingEntity.getPrice());
    }

    @Override
    public void delete(Long thingId) {
        thingRepository.delete(thingId);
    }

    @Override
    public ThingDTO add(ThingDTO thingDTO) throws ThingExistException {
        ThingEntity thingEntity = thingRepository.find(thingDTO.getId());
        if (thingEntity != null)
            throw new ThingExistException("thing.id = " + thingDTO.getId());

        thingRepository.add(
                new ThingEntity(
                        thingDTO.getId(),
                        thingDTO.getName(),
                        thingDTO.getDescription(),
                        thingDTO.getPrice()));

        return thingDTO;
    }

    @Override
    public ThingDTO update(ThingDTO thing) throws ThingNotFoundException {
        get(thing.getId());

        ThingEntity thingEntity = thingRepository.update(new ThingEntity(
                thing.getId(),
                thing.getName(),
                thing.getDescription(),
                thing.getPrice()));

        return new ThingDTO(
                thingEntity.getId(),
                thingEntity.getName(),
                thingEntity.getDescription(),
                thingEntity.getPrice());
    }

}
