package ru.project.exception;

/**
 * Created by aw on 08.04.2017.
 */
public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(String message) {
        super(message);
    }
}
