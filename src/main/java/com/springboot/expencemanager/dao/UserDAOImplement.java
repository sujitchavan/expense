package com.springboot.expencemanager.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.expencemanager.Entity.User;
import com.springboot.expencemanager.conversion.Translator;
import com.springboot.expencemanager.dto.UserDTO;

@Repository
@Transactional
public class UserDAOImplement implements UserDAO, Translator<User, UserDTO> {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void addUser(UserDTO userDTO) {
		User user=new User();
		translateToEntity(user, userDTO);
		entityManager.persist(user);
		
	}

	@Override
	public List<String> loginUser(UserDTO userDTO) {
		User user=new User();
		translateToEntity(user, userDTO);
		Query theQuery=(Query) entityManager.createQuery("select password from User where username = '"+user.getUsername()+"'");
		List<String> pwd = theQuery.list();
		return pwd;
		
	}
	
	public User findUser(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public User translateToEntity(User entity, UserDTO dto) {
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		return entity;
	}

	@Override
	public UserDTO translateToDTO(User entity, UserDTO dto) {
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		return dto;
	}
}
