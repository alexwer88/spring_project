package ru.project.thing.repository.impl;

import ru.project.thing.model.entity.ThingEntity;
import ru.project.thing.repository.ThingRepository;
import org.springframework.stereotype.Service;

@Service
public class ThingRepositoryImpl implements ThingRepository {

    private ThingEntity thingEntity;

    @Override
    public ThingEntity find(long thingId) {
        if (thingEntity != null && thingEntity.getId().equals(thingId))
            return thingEntity;

        return null;
    }

    @Override
    public ThingEntity add(ThingEntity thing) {
        this.thingEntity = thing;
        return thingEntity;
    }

    @Override
    public void delete(long thingId) {
        if (thingEntity != null && thingEntity.getId().equals(thingId))
            this.thingEntity = null;
    }

    @Override
    public ThingEntity update(ThingEntity thing) {
        if (thingEntity == null)
            return null;

        thingEntity.setName(thing.getName());
        thingEntity.setDescription(thing.getDescription());
        thingEntity.setPrice(thing.getPrice());
        return thingEntity;
    }

}
