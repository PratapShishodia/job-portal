package com.ps.backend.mapper;

import com.ps.backend.dto.contactDTO.ContactRequestDTO;
import com.ps.backend.dto.contactDTO.ContactResponseDTO;
import com.ps.backend.entity.Contact;

public class ContactDTOMapper {

    public static ContactResponseDTO toDTO(Contact contact){
        ContactResponseDTO dto = new ContactResponseDTO();

        dto.setContactId(contact.getContactId());
        dto.setFullName(contact.getFullName());
        dto.setUserType(contact.getUserType());
        dto.setSubject(contact.getSubject());
        dto.setMessage(contact.getMessage());
        dto.setStatus(contact.getStatus());
        dto.setUserEmail(contact.getUserEmail());

        return dto;
    }

    public static Contact toEntity(ContactRequestDTO dto){
        Contact contact = new Contact();
        contact.setFullName(dto.getFullName());
        contact.setUserType(dto.getUserType());
        contact.setSubject(dto.getSubject());
        contact.setMessage(dto.getMessage());
        contact.setUserEmail(dto.getUserEmail());
        return contact;
    }
}
