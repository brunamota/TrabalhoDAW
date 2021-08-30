package net.ufjnet.joppool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.ufjnet.joppool.models.User;
import net.ufjnet.joppool.repositories.UserDAO;


@Service
public class GestaoUser implements UserDetailsService{
	
	@Autowired
	private UserDAO dao_user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = dao_user.findByUsername(username);
		
		if(user != null) {
			
			return user;
		}
		else {
			throw new UsernameNotFoundException("Usuario "+ username+ "não encontrado!");
		}
	}

}
