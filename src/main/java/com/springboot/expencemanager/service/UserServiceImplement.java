package com.springboot.expencemanager.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.expencemanager.dao.UserDAO;
import com.springboot.expencemanager.dto.UserDTO;

@Service
public class UserServiceImplement implements UserService {
	private static Logger logger = LogManager.getLogger();

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public String addUser(UserDTO userDTO) {
		
		if(userDTO.getPassword().equals(userDTO.getPasswordConfirm())){
			userDAO.addUser(userDTO);
			logger.info("Successfully user added in db: ");
			return "Successfully Added";
		}
		else {
			logger.error("Password Not match: ");
			return "Password Not match";
		}
	}

	@Override
	public ResponseEntity<String> loginUser(UserDTO userDTO) {
		List<String> pwd=userDAO.loginUser(userDTO);
		if(!pwd.isEmpty() && pwd.get(0).equals(userDTO.getPassword())){
			logger.info("Successfully Login User: ");
			return new ResponseEntity<String>("Successfully Login" , HttpStatus.FOUND);
		}
		logger.error("Successfully not Login User: ");
		return new ResponseEntity<String>("Successfully Not Login" , HttpStatus.NOT_FOUND);
		
	}

}
