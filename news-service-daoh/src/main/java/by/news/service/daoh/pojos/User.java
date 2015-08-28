package by.news.service.daoh.pojos;

import javax.persistence.*;

@Entity
@Table(name = "user")
@SequenceGenerator(name = "PK")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PK")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

/*    @OneToOne
    @JoinColumn(name = "user_id")
    private UserDetail userDetail;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
