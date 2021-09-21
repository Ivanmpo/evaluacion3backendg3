package com.everis.data.services;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.User;
import com.everis.data.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository ur;

	public void save(@Valid User user) {
		
		// hash password
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		ur.save(user);
		
	}

	public boolean validarUsuario(String usuario, String password) {
		User user = ur.findByUsuario(usuario);
		// Siempre validar  si es null 
		if(user == null) {
			return false;
		}else {
			//comparar los passwords
			if( BCrypt.checkpw(password,user.getPassword()) ) {
				System.out.println("Password igual");
				return true;
			}else {
				System.out.println("password distinto");
				return false;
			}
		}
	}

	public User findByUsuario(String email) {
		return ur.findByUsuario(email);
	}
	
	public User findById(Long id) {
		return ur.getById(id);
	}
	
}
