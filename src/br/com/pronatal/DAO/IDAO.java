/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.DAO;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface IDAO <A>{
    public boolean cadastrar(A a);
    public boolean deletar();
    public boolean atualizar(A a);
    public ArrayList<A> getAll();
    public A getById(int id);
}
