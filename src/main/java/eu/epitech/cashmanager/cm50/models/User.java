package eu.epitech.cashmanager.cm50.models;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    private long id;
    private String username;
    private String email;
    private String password;
    private String role;

    public User() { }

    public User(String uname, String mail, String pass, String r)
    {
        username = uname;
        email = mail;
        password = pass;
        role = r;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId()
    {
        return id;
    }
    public void setId()
    {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Column(name = "username", nullable = false)
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    @Column(name = "email", nullable = false)
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Column(name = "password", nullable = false)
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    @Column(name = "role", nullable = false)
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "Users [id=" + id + ", Username=" + username + ", Email=" + email + ", Password=" + password +
        ", Role=" + role + "]";
    }
}
