package by.news.service.vo;

import java.util.Set;

public class UserVO {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String cellPhone;
    private Set<RoleVO> roles;

    public UserVO() {
    }

    public UserVO(String email, String password, String firstName, String lastName, String cellPhone) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Set<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleVO> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", roles=" + roles +
                '}';
    }
}
