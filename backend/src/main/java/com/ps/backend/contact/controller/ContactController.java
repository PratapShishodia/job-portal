package com.ps.backend.contact.controller;

import com.ps.backend.contact.service.ContactService;
import com.ps.backend.dto.ContactRequestDTO;
import com.ps.backend.dto.ContactResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAllByEmail(@RequestParam(defaultValue = "0") int page_num,@RequestParam(defaultValue = "9") int page_size,@RequestParam String email){
        return ResponseEntity.ok(contactService.getAllContactsByEmail(page_num,page_size,email));
    }

    @PostMapping
    public ResponseEntity<ContactResponseDTO> addContact(@Valid @RequestBody ContactRequestDTO requestDTO){
        return ResponseEntity.ok(contactService.addContact(requestDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteContact(@RequestParam int ID){
        return ResponseEntity.ok(contactService.deleteContact(ID));
    }
}
