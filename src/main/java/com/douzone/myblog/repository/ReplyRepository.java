package com.douzone.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douzone.myblog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
