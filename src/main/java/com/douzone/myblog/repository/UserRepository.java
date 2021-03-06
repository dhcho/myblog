package com.douzone.myblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douzone.myblog.model.User;

// DAO
// 자동으로 Bean 등록이 된다.
// @Repository 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer> {
	// JPA Naming 쿼리
	// SELCT * FROM user WHERE username = ? AND password = ?;
	// User findByUsernameAndPassword(String username, String password);
	
	// @Query(value="SELCT * FROM user WHERE username = ? AND password = ?", nativeQuery = true)
	// User login(String username, String password);
	
	// SELECT * FROM user WHERE username = ?;
	Optional<User> findByUsername(String username);
}
