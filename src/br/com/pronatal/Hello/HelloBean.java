/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pronatal.Hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author pedro
 */
@ManagedBean(name = "helloMB")
public class HelloBean {
	private String message;
	
    public String getHello(){
        return message;
    }
    
    public void setHello(String newMessage) {
    	this.message = newMessage;
    }
    
    public String digaOla() {
    	return "Ola " + message;
    }
}
