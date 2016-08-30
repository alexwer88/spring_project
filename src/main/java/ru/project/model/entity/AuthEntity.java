package ru.project.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by averizhnikov on 25.08.2016.
 */
@Entity
@Table(name = "auth")
public class AuthEntity {

    @Id
    @Column(name = "auth_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auth_id_gen")
    @SequenceGenerator(name = "auth_id_gen", sequenceName = "public.auth_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "sequence_id")
    private String sequenceId;

    @Column(name = "request_date")
    private Date requestDate;

    @Column(name = "result")
    private String result;

    @Column(name = "token")
    private String token;

    @Column(name = "token_expiration_date")
    private Date tokenExpirationDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public AuthEntity() {

    }

    public AuthEntity(String sequenceId, Date requestDate, String result, String token, Date tokenExpirationDate, UserEntity user) {
        this.sequenceId = sequenceId;
        this.requestDate = requestDate;
        this.result = result;
        this.token = token;
        this.tokenExpirationDate = tokenExpirationDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
