package com.sp.jobportal.contact.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.jobportal.contact.service.ContactService;
import com.sp.jobportal.dto.ContactRequestDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
public class ContactController {

	private final ContactService contactService;

	@PostMapping(version = "1.0")
	public ResponseEntity<String> saveContact(@RequestBody ContactRequestDto contactRequestDto) {
		boolean isSaved = contactService.saveContact(contactRequestDto);
		if (isSaved) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save contact");

	}

}
