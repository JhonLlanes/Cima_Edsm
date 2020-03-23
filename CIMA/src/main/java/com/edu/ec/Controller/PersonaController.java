package com.edu.ec.Controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.edu.ec.Bussines.LoginBussines;
import com.edu.ec.Bussines.PersonaBussines;

import com.edu.ec.Modelos.Login;
import com.edu.ec.Modelos.Persona;
import com.edu.ec.Modelos.Rol;

@ManagedBean
public class PersonaController {
	
	@Inject
	private  LoginBussines logBus;
	
	@Inject
	private PersonaBussines perBus;
	
	Persona persona = new Persona();
	Login login = new Login();
	Rol rol = new Rol();
	
	
	@PostConstruct
	public void init() {
		
	}
	
	
	public void guardar () {
		try {
			int idLogin= logBus.guardarLogin(login);
			Login log = new Login();
			log.setLog_id(idLogin);
			persona.setLogin(log);
			persona.setRol(rol);
			perBus.guardarPersona(persona);
			addMessage("Guardado");
		} catch (Exception e) {
		 e.printStackTrace();
		 addMessage("ERROR");
		}
		
	}
	
	
	  public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	  

	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Login getLogin() {
		return login;
	}


	public void setLogin(Login login) {
		this.login = login;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

}
