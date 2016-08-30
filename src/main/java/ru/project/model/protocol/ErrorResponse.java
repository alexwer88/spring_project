package ru.project.model.protocol;

import javax.validation.constraints.NotNull;

/**
 * Created by averizhnikov on 25.08.2016.
 */
public class ErrorResponse extends Protocol {

    @NotNull
    private Error data;

    public ErrorResponse(String sequenceId, Error error) {
        super("CUSTOMER_ERROR", sequenceId);
        this.data = error;
    }

    public Error getData() {
        return data;
    }

    public void setData(Error data) {
        this.data = data;
    }
}
