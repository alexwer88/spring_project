package ru.project.model.protocol;

import java.util.List;

/**
 * Created by user on 30.09.16.
 */
public class UserPhoneProtocol {

    private String name;

    private List<String> numbers;


    public UserPhoneProtocol(String name, List<String> numbers) {
        this.name = name;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }
}
