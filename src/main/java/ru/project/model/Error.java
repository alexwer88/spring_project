package ru.project.model;

/**
 * Модель, реализующая описание ошбки
 * Created by aw on 08.04.2017.
 */
public class Error {

    int code;
    String description;

    public Error() {

    }

    public Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
