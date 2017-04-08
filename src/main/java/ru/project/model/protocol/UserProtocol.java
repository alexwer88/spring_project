package ru.project.model.protocol;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by user on 30.09.16.
 */
public class UserProtocol {

    @NotNull
    @Size(min = 1)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
