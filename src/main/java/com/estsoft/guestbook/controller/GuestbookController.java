package com.estsoft.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estsoft.guestbook.domain.Guestbook;
import com.estsoft.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	
	@Autowired
	GuestbookService guestbookService;

	@RequestMapping( "/" )
	public String index( Model model ) {
		List<Guestbook> list = guestbookService.getMessageList();
		model.addAttribute( "list", list );
		return "index";
	}
	
	@RequestMapping( "/deleteform/{no}" )
	public String deletefrom( @PathVariable( "no" ) Long no, Model model ) {
		model.addAttribute( "no", no );
		return "deleteform";
	}

	@RequestMapping( "/delete" )
	public String delete( @ModelAttribute Guestbook guestbook ) {
		guestbookService.deleteMessage( guestbook );
		return "redirect:/";
	}

	@RequestMapping( "/insert" )
	public String insert( @ModelAttribute Guestbook guestbook ) {
		guestbookService.insertMessage(guestbook);
		return "redirect:/";
	}
	
}