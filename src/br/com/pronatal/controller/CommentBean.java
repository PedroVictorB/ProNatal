package br.com.pronatal.controller;

import javax.faces.bean.ManagedBean;

import br.com.pronatal.model.Comment;

@ManagedBean
public class CommentBean {
	private Comment comment;
	
	public Comment getComment() {
		return comment;
	}
	
	public void setComment (Comment comment) {
		this.comment = comment;
	}
	
	public String addComment() {
		return "added";
	}
	
	public String removeComment() {
		return "removed";
	}
}
