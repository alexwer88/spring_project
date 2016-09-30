package ru.project.model.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

/**
 * Created by user on 30.09.16.
 */

@Entity
@Table(name = "phones")
@JsonAutoDetect
public class Phone {

    @Id
    @Column(name = "phone_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_id_gen")
    @SequenceGenerator(name = "phone_id_gen", sequenceName = "public.phones_id_seq", allocationSize = 1)
    private Integer id;


    @Column(name = "phone_number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }
}
