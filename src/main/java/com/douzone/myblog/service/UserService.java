package com.douzone.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.myblog.model.User;
import com.douzone.myblog.repository.UserRepository;

// 스프링이 컨포넌트 스캔을 통해서 Bean에 등록. IoC를 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void join(User user) {
			userRepository.save(user);
	}
}
