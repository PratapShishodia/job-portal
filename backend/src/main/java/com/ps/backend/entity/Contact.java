package com.ps.backend.entity;

import com.ps.backend.enums.ContactSubject;
import com.ps.backend.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tbl_contact")
public class Contact extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",nullable = false)
    private long contactId;
    @Column(name = "FULLNAME",nullable = false)
    private String fullName;
    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private Roles userType;
    @Column(name = "SUBJECT")
    @Enumerated(EnumType.STRING)
    private ContactSubject subject;
    @Column(name = "Message",length = 500)
    public String message;
    @Column(name = "Status",columnDefinition = "varchar(255) default 'NEW'")
    public String status;
    @Column(name = "USER_EMAIL")
    public String userEmail;
}
