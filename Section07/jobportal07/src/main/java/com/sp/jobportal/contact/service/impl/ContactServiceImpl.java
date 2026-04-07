package com.sp.jobportal.contact.service.impl;

import java.time.Instant;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sp.jobportal.company.repository.ContactRepository;
import com.sp.jobportal.contact.service.ContactService;
import com.sp.jobportal.dto.ContactRequestDto;
import com.sp.jobportal.entity.Contact;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

	private final ContactRepository contactRepository;

	@Override
	public boolean saveContact(ContactRequestDto contactRequestDto) {
		// TODO Auto-generated method stub
		Contact contact = contactRepository.save(transformToEntity(contactRequestDto));
		if (contact != null && contact.getId() != null) {
			return true;
		}
		return false;
	}

	public Contact transformToEntity(ContactRequestDto contactRequestDto) {
		Contact contact = new Contact();
		//		contact.setName(contactRequestDto.name());
		//		contact.setEmail(contactRequestDto.email());
		//		contact.setMessage(contactRequestDto.message());
		//		contact.setSubject(contactRequestDto.subject());
		//		contact.setUserType(contactRequestDto.userType());
		BeanUtils.copyProperties(contactRequestDto, contact);
		contact.setCreatedAt(Instant.now());
		contact.setCreatedBy("SYSTEM");
		contact.setStatus("NEW");
		return contact;
	}

}
