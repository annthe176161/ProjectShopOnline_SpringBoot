package org.shoponline.shoponline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
public class UserRoleMap {
    @EmbeddedId
    private UserRoleMapId id;

    @MapsId("userID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UserID", nullable = false)
    private User userID;

    @MapsId("roleID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RoleID", nullable = false)
    private UserRole roleID;

    @ColumnDefault("getdate()")
    @Column(name = "AssignedAt")
    private Instant assignedAt;

}