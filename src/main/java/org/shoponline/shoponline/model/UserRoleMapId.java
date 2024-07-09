package org.shoponline.shoponline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserRoleMapId implements java.io.Serializable {
    private static final long serialVersionUID = 2738824059696290598L;
    @Column(name = "UserID", nullable = false)
    private Integer userID;

    @Column(name = "RoleID", nullable = false)
    private Integer roleID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRoleMapId entity = (UserRoleMapId) o;
        return Objects.equals(this.roleID, entity.roleID) &&
                Objects.equals(this.userID, entity.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID, userID);
    }

}