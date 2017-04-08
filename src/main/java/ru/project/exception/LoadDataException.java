package ru.project.exception;

/**
 * Исключение, возникающее при ошибке загрузки и формирования данных
 * Created by aw on 08.04.2017.
 */
public class LoadDataException extends RuntimeException {

    public LoadDataException(String message) {
        super(message);
    }
}
