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
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "UserName", nullable = false, length = 50)
    private String userName;

    @Nationalized
    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @Nationalized
    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Nationalized
    @Column(name = "FullName", length = 100)
    private String fullName;

    @Nationalized
    @Column(name = "Phone", length = 20)
    private String phone;

    @ColumnDefault("getdate()")
    @Column(name = "CreatedAt")
    private Instant createdAt;

    @ColumnDefault("getdate()")
    @Column(name = "UpdatedAt")
    private Instant updatedAt;

}