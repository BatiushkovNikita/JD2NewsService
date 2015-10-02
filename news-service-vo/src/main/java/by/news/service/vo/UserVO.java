package by.news.service.vo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserVO implements UserDetails, Serializable {

    private Logger Log = LogManager.getLogger(UserVO.class.getName());

    private static final long serialVersionUID = 1L;

    private int id;

    @NotBlank(message = "{error.email.input}")
    private String email;

    @Size(min = 6, max = 20, message = "${frag.userdata.email.error.input}")
    private String password;
    private String firstName;

    @NotNull(message = "dsdsdssd NOT NULL")
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

    public UserVO(int id, String email, String password, String firstName, String lastName, String cellPhone, Set<RoleVO> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
        this.roles = roles;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> rolesSet = new HashSet<>();
        for (RoleVO role : roles) {
            rolesSet.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return rolesSet;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserVO userVO = (UserVO) o;

        if (id != userVO.id) return false;
        if (cellPhone != null ? !cellPhone.equals(userVO.cellPhone) : userVO.cellPhone != null) return false;
        if (email != null ? !email.equals(userVO.email) : userVO.email != null) return false;
        if (firstName != null ? !firstName.equals(userVO.firstName) : userVO.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userVO.lastName) : userVO.lastName != null) return false;
        if (password != null ? !password.equals(userVO.password) : userVO.password != null) return false;
        if (roles != null ? !roles.equals(userVO.roles) : userVO.roles != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (cellPhone != null ? cellPhone.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
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
