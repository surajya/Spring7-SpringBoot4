package com.sp.jobportal.contact.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sp.jobportal.contact.service.ContactService;
import com.sp.jobportal.dto.ContactRequestDto;
import com.sp.jobportal.entity.Contact;
import com.sp.jobportal.repository.ContactRepository;

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
		BeanUtils.copyProperties(contactRequestDto, contact);
		contact.setStatus("NEW");
		return contact;
	}

}
