package com.example.rest.services.Messanger.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.rest.services.Messanger.model.Comment;

class CommentServiceTest {
	
	MessageService msgService;
	
	CommentService commentService;
	
	@BeforeEach
	void init() {
		msgService = new MessageService();
		commentService = new CommentService();
	}
	
	@Test
	void testaddComment() {
		List<Comment> comments = commentService.getAllComments(1);
		assertEquals(0, comments.size());		
		commentService.addComment(1, createCommentObject("Mani", "Wow"));
	    comments = commentService.getAllComments(1);
	    assertEquals(1, comments.size());
	    assertEquals(1, comments.get(0).getId());
	}
	
	
	@Test
	void testgetAllComments() {
		List<Comment> comments = commentService.getAllComments(1);
		assertEquals(0, comments.size());		
		commentService.addComment(1, createCommentObject("Mani", "Wow"));
		commentService.addComment(1, createCommentObject("Kar", "Super"));
	    comments = commentService.getAllComments(1);
	    assertEquals(2, comments.size());
	    assertEquals("Mani", comments.get(0).getAuthor());
	}
	
	private static Comment createCommentObject(String author,String message) {
		Comment comment = new Comment();
		comment.setAuthor("Mani");
		comment.setCreated(new Date());
		comment.setMessage("Super");
		return comment;
	}

}
