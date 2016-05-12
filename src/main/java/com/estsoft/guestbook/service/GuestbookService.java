package com.estsoft.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;
import com.estsoft.guestbook.repository.GuestbookRepository;


@Service
@Transactional
public class GuestbookService {
	@Autowired
	GuestbookRepository guestbookRepository;
	
	public List<Guestbook> getMessageList() {
		return guestbookRepository.findAll();
	}
	
	public boolean deleteMessage( Guestbook guestbook ) {
		return guestbookRepository.remove( guestbook );
	}
	
	public void insertMessage( Guestbook guestbook ) {
		guestbookRepository.save( guestbook );
	}
}