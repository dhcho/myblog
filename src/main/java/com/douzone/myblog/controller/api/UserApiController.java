package com.douzone.myblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.myblog.dto.ResponseDto;
import com.douzone.myblog.model.User;
import com.douzone.myblog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { // username, password, email
		System.out.println("UserApiController : save 호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return이 되면 돼요.
		
		userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson)
	}
	
	// 다음시간에 스프링 시큐리티 이용해서 로그인!!
	//	@PostMapping("/api/user/login")
	//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
	//		System.out.println("User ApiController : login호출됨");
	//		User principal = userService.login(user); // principal (접근주체)
	//		
	//		if(principal != null) {
	//			session.setAttribute("principal", principal);
	//		}
	//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	//	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) {// key=value, x-www-form-urlencoded
		userService.update(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
