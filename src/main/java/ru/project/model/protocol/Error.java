package ru.project.model.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by averizhnikov on 25.08.2016.
 */
public class Error {

    @JsonProperty("error_description")
    private String errorDescription;

    @JsonProperty("error_code")
    private String errorCode;

    public Error() {

    }

    public Error(String errorDescription, String errorCode) {
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
