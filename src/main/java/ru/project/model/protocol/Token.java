package ru.project.model.protocol;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Created by averizhnikov on 25.08.2016.
 */


public class Token {

    @JsonProperty("api_token")
    private String token;

    @JsonProperty("api_token_expiration_date")
    private Date tokenExpirationDate;


    public Token(String token, Date tokenExpirationDate) {
        this.token = token;
        this.tokenExpirationDate = tokenExpirationDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(Date tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }
}
