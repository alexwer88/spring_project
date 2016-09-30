package ru.project.model.protocol;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by user on 30.09.16.
 */
public class PhoneProtocol {

    @NotNull
    @Size(min = 1)
    private String phoneNumber;

    private Integer userId;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
