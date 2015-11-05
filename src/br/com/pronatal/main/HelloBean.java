package br.com.pronatal.main;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean {
	public String getMessage() {
		return "Hello";
	}
}
