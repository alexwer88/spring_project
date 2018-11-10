package ru.project.thing.repository;

import ru.project.thing.model.entity.ThingEntity;

public interface ThingRepository {

    ThingEntity find(long thingId);

    ThingEntity add(ThingEntity thing);

    void delete(long thingId);

    ThingEntity update(ThingEntity thing);
}
