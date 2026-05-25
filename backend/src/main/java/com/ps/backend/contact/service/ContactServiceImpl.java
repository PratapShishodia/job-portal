package com.ps.backend.contact.service;

import com.ps.backend.dto.CompanyRequestDTO;
import com.ps.backend.dto.ContactRequestDTO;
import com.ps.backend.dto.ContactResponseDTO;
import com.ps.backend.entity.Contact;
import com.ps.backend.mapper.ContactDTOMapper;
import com.ps.backend.repository.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{

    private final ContactRepo contactRepo;

    @Override
    public List<ContactResponseDTO> getAllContactsByEmail(int page_num, int page_size, String userEmail) {
        Pageable pageable = PageRequest.of(page_num,page_size);
        Page<Contact> contactPage = contactRepo.findAllByUserEmail(pageable,userEmail);
        List<Contact> contactList = contactPage.getContent();
        return contactList.stream().map(ContactDTOMapper::toDTO).toList();
    }

    public ContactResponseDTO addContact(ContactRequestDTO requestDTO) {
        Contact contact = contactRepo.save(ContactDTOMapper.toEntity(requestDTO));
        return ContactDTOMapper.toDTO(contact);
    }

    public String deleteContact(long contactId) {
        Contact contact = contactRepo.findById(contactId).orElseThrow(() -> new RuntimeException("Contact not Found for id: "+contactId));
        contactRepo.delete(contact);
        return "Deleted Successfully";
    }
}
