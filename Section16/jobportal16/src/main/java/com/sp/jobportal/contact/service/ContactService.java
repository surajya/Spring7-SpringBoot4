package com.sp.jobportal.contact.service;

import com.sp.jobportal.dto.ContactRequestDto;
import com.sp.jobportal.dto.ContactResponseDto;

import java.util.List;

public interface ContactService {

    public boolean saveContact(ContactRequestDto contactRequestDto);

    List<ContactResponseDto> fetchNewContactMsgs();
}
