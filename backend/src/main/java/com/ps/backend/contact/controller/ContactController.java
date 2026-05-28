package com.ps.backend.contact.controller;

import com.ps.backend.contact.service.ContactService;
import com.ps.backend.dto.contactDTO.ContactRequestDTO;
import com.ps.backend.dto.contactDTO.ContactResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/{email}")
    public ResponseEntity<List<ContactResponseDTO>> getContactsByEmail(@RequestParam(required = false,defaultValue = "0") int page_num, @RequestParam(required = false,defaultValue = "10") int page_size, @PathVariable String email) {
        return ResponseEntity.ok(contactService.getContactsByEmail(page_num, page_size, email));
    }

    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAllContacts(@RequestParam(required = false,defaultValue = "0") int page_num, @RequestParam(required = false,defaultValue = "10") int page_size) {
        return ResponseEntity.ok(contactService.getContacts(page_num, page_size));
    }

//    @PostMapping
//    public ResponseEntity<ContactResponseDTO> createContact(@Valid @RequestBody ContactRequestDTO contactDTO) {
//        return ResponseEntity.ok(contactService.addContact(contactDTO));
//    }

    @PostMapping
    public ResponseEntity<List<ContactResponseDTO>> createContact(@Valid @RequestBody List<ContactRequestDTO> contactDTO) {
        List<ContactResponseDTO> list = new ArrayList<>();
        for (ContactRequestDTO contactDTO1 : contactDTO) {
            list.add(contactService.addContact(contactDTO1));
        }
        return ResponseEntity.ok(list);
    }

    @PatchMapping("/close")
    public ResponseEntity<Boolean> updateContact(@RequestParam long contactID,@RequestParam(defaultValue = "CLOSED",required = false) String status) {
        return ResponseEntity.ok(contactService.updateContact(contactID,status));
    }

}
