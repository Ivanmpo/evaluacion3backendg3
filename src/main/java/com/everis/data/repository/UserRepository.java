package com.everis.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.data.models.User;



public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsuario(String usuario);

}
