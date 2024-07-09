package org.shoponline.shoponline.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "UserRoles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "RoleName", nullable = false, length = 50)
    private String roleName;

    @Nationalized
    @Column(name = "Description")
    private String description;

    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt")
    private Instant createdAt;

    @ColumnDefault("getdate()")
    @Column(name = "UpdatedAt")
    private Instant updatedAt;

}