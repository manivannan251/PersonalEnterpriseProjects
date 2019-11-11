package com.example.rest.services.Messanger.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.example.rest.services.Messanger.model.Message;

class MessageServiceTest {

	MessageService msgService;
	
	@BeforeEach
	void init() {
		msgService = new MessageService();
	}
	
	@Nested
	class testMessagesInYear {
	@Test
	void testgetAllMessagesInYear() {
		
		List<Message> msgInYear = msgService.getAllMessagesInYear(2019);
		assertEquals(2, msgInYear.size());
	}
	
	@Test
	void testgetAllMessagesInYearForYear() {
		Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
		Message message = new Message();
		message.setAuthor("TestAuthor");
		message.setMessage("Test Message");
		message.setDateCreated(date);
		msgService.addMessage(message);
		List<Message> msgInYear = msgService.getAllMessagesInYear(2014);
		assertEquals(1, msgInYear.size());
		assertEquals("TestAuthor", msgInYear.get(0).getAuthor());
	}
	}
	
	@Test
	void testgetAllMessagesPaginated() {
		Message message = new Message();
		message.setAuthor("TestAuthor");
		message.setMessage("Test Message");
		message.setDateCreated(new Date());
		msgService.addMessage(message);
		List<Message> pagintedMessage = msgService.getAllMessagesPaginated(1, 2);
		System.out.println(pagintedMessage);
		assertEquals(2, pagintedMessage.size());
		assertEquals(2, pagintedMessage.get(0).getId());
		assertEquals(3, pagintedMessage.get(1).getId());
	}
	
	@Test
	void testremoveMessage() {
		msgService.removeMessage(1);
		List<Message> messages = msgService.getAllMessages();
		assertEquals(1, messages.size());
		assertEquals(2, messages.get(0).getId());
	}

}
