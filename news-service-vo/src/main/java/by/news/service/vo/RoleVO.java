package by.news.service.vo;

import java.io.Serializable;

public class RoleVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String roleName;

    public RoleVO() {
    }

    public RoleVO(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleVO roleVO = (RoleVO) o;

        if (id != roleVO.id) return false;
        if (roleName != null ? !roleName.equals(roleVO.roleName) : roleVO.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RoleVO{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
