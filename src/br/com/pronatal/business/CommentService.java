/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.business;

import br.com.pronatal.dao.DAOFactory;
import br.com.pronatal.dao.IDAO;
import br.com.pronatal.model.Comment;
import br.com.pronatal.model.Problem;
import java.util.List;

/**
 *
 * @author brunomoreira
 */
public class CommentService {
    	private IDAO<Comment> daoComment;
	
	public CommentService() {
            daoComment = DAOFactory.getCommentDAO();
	}
	
	public void registerComment(Comment comment) {
            daoComment.create(comment);
	}
	
	public List<Comment> retrieveAllComment() {
            return daoComment.retrieveAll();
	}
        
        public Comment retrieveCommentById(int id){
            return daoComment.retrieveById(id);
        }
        
        public void updateComment(Comment comment){
            daoComment.update(comment);
        }
}
