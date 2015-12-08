/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.dao; 

import java.util.List;

/**
 *
 * @author pedro
 */
public interface IDAO <T> {
    public void create(T obj);
    public void delete();
    public void update(T obj);
    public T retrieve(T obj);
    public List<T> retrieveAll();
    public T retrieveById(int id);
}
