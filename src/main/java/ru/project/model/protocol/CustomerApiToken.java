package ru.project.model.protocol;

/**
 * Created by averizhnikov on 25.08.2016.
 */
public class CustomerApiToken extends Protocol {

    private Token data;

    public CustomerApiToken(String sequenceId,  Token data) {
        super("CUSTOMER_API_TOKEN", sequenceId);
        this.data = data;
    }

    public Token getData() {
        return data;
    }

    public void setData(Token data) {
        this.data = data;
    }
}
