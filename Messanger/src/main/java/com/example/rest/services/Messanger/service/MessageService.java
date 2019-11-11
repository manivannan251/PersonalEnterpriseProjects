package com.example.rest.services.Messanger.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.rest.services.Messanger.database.DatabaseClass;
import com.example.rest.services.Messanger.exception.DataNotFoundException;
import com.example.rest.services.Messanger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	public MessageService() {
		messages.put(1L, new Message(1L, "First Message", "Goku"));
		messages.put(2L, new Message(2L, "Second Message", "Goku"));
	}
	
	public List<Message> getAllMessages() {		
		return new ArrayList(messages.values());
	}
	
	
	public List<Message> getAllMessagesInYear(int year) {
		
		return messages.values().stream().filter(m->{
			Calendar cal = Calendar.getInstance();
			cal.setTime(m.getDateCreated());
			return cal.get(Calendar.YEAR)==year?true:false;
		}).collect(Collectors.toList());
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size) {
		List<Message> paginatedMsg = new ArrayList(messages.values());
		if(start+size>messages.size())
			return new ArrayList<Message>();
		return paginatedMsg.subList(start, start+size);
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);;
		if(message==null) 
			throw new DataNotFoundException("The message with message id "+id+" not found ");
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	
	public Message updateMessage(Message message) {
		if(message.getId()<0)
			return null;
		messages.put(message.getId(), message);		
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
