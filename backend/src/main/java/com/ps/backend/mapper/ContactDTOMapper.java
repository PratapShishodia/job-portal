package com.ps.backend.mapper;

import com.ps.backend.dto.ContactRequestDTO;
import com.ps.backend.dto.ContactResponseDTO;
import com.ps.backend.entity.Contact;

public class ContactDTOMapper {

    public static ContactResponseDTO toDTO(Contact contact){
        ContactResponseDTO responseDTO = new ContactResponseDTO();
        responseDTO.setContactId(contact.getContactId());
        responseDTO.setFullName(contact.getFullName());
        responseDTO.setUserType(contact.getUserType());
        responseDTO.setSubject(contact.getSubject());
        responseDTO.setMessage(contact.getMessage());
        responseDTO.setStatus(contact.getStatus());
        responseDTO.setUserEmail(contact.getUserEmail());
        return responseDTO;
    }

    public static Contact toEntity(ContactRequestDTO requestDTO){
        Contact contact = new Contact();
        contact.setFullName(requestDTO.getFullName());
        contact.setUserType(requestDTO.getUserType());
        contact.setSubject(requestDTO.getSubject());
        contact.setMessage(requestDTO.getMessage());
        contact.setStatus(requestDTO.getStatus());
        contact.setUserEmail(requestDTO.getUserEmail());
        return contact;
    }
}
