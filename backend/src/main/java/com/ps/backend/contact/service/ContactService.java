package com.ps.backend.contact.service;


import com.ps.backend.dto.ContactRequestDTO;
import com.ps.backend.dto.ContactResponseDTO;

import java.util.List;

public interface ContactService {
    public List<ContactResponseDTO> getAllContactsByEmail(int page_num,int page_size,String userEmail);
    public ContactResponseDTO addContact(ContactRequestDTO requestDTO);
    public String deleteContact(long contactId);
}
