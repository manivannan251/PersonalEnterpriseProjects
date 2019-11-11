package com.example.rest.services.Messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.example.rest.services.Messanger.database.DatabaseClass;

import com.example.rest.services.Messanger.model.Comment;
import com.example.rest.services.Messanger.model.ErrorMessage;
import com.example.rest.services.Messanger.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	
	public Comment getComment(long messageId,long commentId) {
		ErrorMessage em = new ErrorMessage("Not found", 404, "google web exception");
		Response resp = Response.status(Status.NOT_FOUND).entity(em).build();
		Message message = messages.get(messageId);
		if(message==null)
			throw new WebApplicationException(resp);
		Map<Long, Comment> comments = message.getComments();
		Comment comment = comments.get(commentId);
		if(comment==null)
			throw new NotFoundException(resp);
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId,Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId,Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId()<0)
			return null;		
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId,long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
