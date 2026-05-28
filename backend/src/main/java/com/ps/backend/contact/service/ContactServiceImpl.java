package com.ps.backend.contact.service;

import com.ps.backend.dto.contactDTO.ContactRequestDTO;
import com.ps.backend.dto.contactDTO.ContactResponseDTO;
import com.ps.backend.entity.Contact;
import com.ps.backend.mapper.ContactDTOMapper;
import com.ps.backend.repository.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContactServiceImpl implements ContactService {

    private final ContactRepo contactRepo;

    public List<ContactResponseDTO> getContactsByEmail(int page_num, int page_size, String email) {
        Pageable pageable = PageRequest.of(page_num, page_size);
        Page<Contact> contactResponseDTOPage = contactRepo.findAllByUserEmail(pageable,email);
        List<Contact> contactResponseDTOList = contactResponseDTOPage.getContent();
        return contactResponseDTOList.stream().map(ContactDTOMapper::toDTO).toList();
    }

    public List<ContactResponseDTO> getContacts(int page_num, int page_size) {
        Pageable pageable = PageRequest.of(page_num, page_size);
        Page<Contact> contactResponseDTOPage = contactRepo.findAll(pageable);
        List<Contact> contactResponseDTOList = contactResponseDTOPage.getContent();
        return contactResponseDTOList.stream().map(ContactDTOMapper::toDTO).toList();
    }

    @Transactional
    public ContactResponseDTO addContact(ContactRequestDTO contactRequestDTO) {
        Contact contact = ContactDTOMapper.toEntity(contactRequestDTO);
        return ContactDTOMapper.toDTO(contactRepo.save(contact));
    }

    @Transactional
    public boolean updateContact(long contactId, String status) {
        int updatedRows = contactRepo.updateContactById(contactId,status);
        return updatedRows > 0;
//        Contact contact = contactRepo.findById(contactId).get();
//        contact.setStatus("CLOSED");
//        return ContactDTOMapper.toDTO(contactRepo.save(contact)) ;
    }

}
