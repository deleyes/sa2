package be.kdg.prog3.upvote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USE_ID")
    private long id;

    @Column(name = "USE_NAME", length=20, nullable = false)
    private String name;

    @Column(name = "USE_EMAIL", length=100, nullable = false)
    private String email;

    @Column(name = "USE_PASSWORD", length=100, nullable = false)
    private String password;

    protected User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
