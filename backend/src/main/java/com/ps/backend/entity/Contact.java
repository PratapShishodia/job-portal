package com.ps.backend.entity;

import com.ps.backend.enums.ContactSubject;
import com.ps.backend.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@NamedQueries({
        @NamedQuery(
                name = "Contact.updateContactById",
                query = "Update Contact c set c.status = :status  where c.contactId = :contactId "
        )
})
@Getter
@Setter
@Entity
@Table(name = "tbl_contact")
public class Contact extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTACT_ID")
    private long contactId;
    @Column(name = "FULLNAME")
    private String fullName;
    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private Roles userType;
    @Column(name = "SUBJECT")
    @Enumerated(EnumType.STRING)
    private ContactSubject subject;
    @Column(name = "MESSAGE")
    public String message;
    @Column(name = "STATUS",columnDefinition = "varchar(255) default 'NEW'")
    public String status = "NEW";
    @Column(name = "USER_EMAIL")
    public String userEmail;
}
