package com.douzone.myblog.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.myblog.dto.ResponseDto;
import com.douzone.myblog.model.User;

@RestController
public class UserApiController {
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출됨");
		// 실제로 DB에 insert를 하고 아래에서 return이 되면 돼요.
		return new ResponseDto<Integer>(HttpStatus.OK, 1); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson)
	}
}
