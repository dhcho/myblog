package com.douzone.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douzone.myblog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
