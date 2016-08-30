package ru.project.model.protocol;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created by averizhnikov on 25.08.2016.
 */

public class LoginCustomer extends Protocol {

    @NotNull
    private User data;

    public LoginCustomer() {
        super();
    }

    public LoginCustomer(String sequence_id, User user) {
        super("LOGIN_CUSTOMER", sequence_id);
        this.data = user;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
