package com.edu.ec.Bussines;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.edu.ec.Dao.LoginDao;
import com.edu.ec.Modelos.Login;

@Stateless
public class LoginBussines {
	

	@Inject
	private LoginDao logDao;
	
	public int guardarLogin(Login login) {
		return logDao.insertUsuario(login);		
	}

}
