package com.douzone.myblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
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
		// 여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됐음.
		// 하지만 세션값은 변경되지 않은 상태이기 때문에 우리가 직접 세션값을 변경해줄 것임.
		// 세션 등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
