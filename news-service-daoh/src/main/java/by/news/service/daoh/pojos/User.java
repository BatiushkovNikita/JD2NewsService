package by.news.service.daoh.pojos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int userID;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;


    public User() {

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userID != user.userID) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userID;
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
