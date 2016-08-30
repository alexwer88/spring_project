package ru.project.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by averizhnikov on 25.08.2016.
 */
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<AuthEntity> auths;

    public UserEntity() {

    }

    public UserEntity(String email, String password, Boolean active) {
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<AuthEntity> getAuths() {
        return auths;
    }

    public void setAuths(List<AuthEntity> auths) {
        this.auths = auths;
    }
}
