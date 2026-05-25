package com.ps.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tbl_users")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "USER_ID")
    private long userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Column(name = "HASH_PASSWORD")
    private String password;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "ROLE")
    private String role;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    private Profile profile;
}
