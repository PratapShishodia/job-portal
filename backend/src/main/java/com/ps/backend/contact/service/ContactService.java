package com.ps.backend.contact.service;

import com.ps.backend.dto.contactDTO.ContactRequestDTO;
import com.ps.backend.dto.contactDTO.ContactResponseDTO;

import java.util.List;

public interface ContactService {
    public List<ContactResponseDTO> getContactsByEmail(int page_num, int page_size,String email);
    public List<ContactResponseDTO> getContacts(int page_num, int page_size);
    public ContactResponseDTO addContact(ContactRequestDTO contactRequestDTO);
    public boolean updateContact(long contactId,String status);
}
