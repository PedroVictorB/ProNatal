/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.dao;

import br.com.pronatal.model.Problem;
import br.com.pronatal.model.User;
import java.io.Serializable;

/**
 *
 * @author brunomoreira
 */
public class DAOFactory implements Serializable {
    public static IDAO<Problem> getProblemDAO() {
	return ProblemDAOMemory.getInstance();
    }
    
    public static IDAO<User> getUserDAO() {
	return UserDAOMemory.getInstance();
    }
}
