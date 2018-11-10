package ru.project.thing.controller;

import ru.project.thing.exception.ThingExistException;
import ru.project.thing.exception.ThingNotFoundException;
import ru.project.thing.model.dto.ThingDTO;
import ru.project.thing.service.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class ThingController {

    @Autowired
    private ThingService thingService;

    @GetMapping("/things/{thingId}")
    public ThingDTO getThing(@NotNull @PathVariable("thingId") Long thingId) throws ThingNotFoundException {
        return thingService.get(thingId);
    }

    @DeleteMapping("/things/{thingId}")
    public void delThing(@NotNull @PathVariable("thingId") Long thingId) {
        thingService.delete(thingId);
    }

    @PostMapping("/things")
    public ThingDTO addThing(@NotNull @RequestBody ThingDTO thingDTO) throws ThingExistException {
        return thingService.add(thingDTO);
    }

    @PutMapping("/things")
    public ThingDTO updateThing(@NotNull @RequestBody ThingDTO thingDTO) throws ThingNotFoundException {
        return thingService.update(thingDTO);
    }

    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex) {
        return ex.getClass().getCanonicalName() + ": " + ex.getMessage();
    }


}
