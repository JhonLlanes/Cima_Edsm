package com.edu.ec.Dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.edu.ec.Modelos.Login;

@Stateless
public class LoginDao {
	
	@Inject
	private EntityManager em;
	
	public int insertUsuario(Login login) {
		em.persist(login);
		return login.getLog_id();
	}	
}
