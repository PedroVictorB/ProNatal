/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.dao;

import br.com.pronatal.model.Comment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brunomoreira
 */
public class CommentDAOMemory implements IDAO<Comment>, Serializable{

    private static CommentDAOMemory instance;
    
    private ArrayList<Comment> comments;
    
    private int id = 0;
    
    public static CommentDAOMemory getInstance(){
        if(instance == null){
            return new CommentDAOMemory();
        }
        return instance;
    }
    
    @Override
    public void create(Comment comment) {
        comment.setId(id);
        comments.add(comment);
        id++;
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comment retrieve(Comment obj) {
        return null;
    }

    @Override
    public List<Comment> retrieveAll() {
        return comments;
    }

    @Override
    public Comment retrieveById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
