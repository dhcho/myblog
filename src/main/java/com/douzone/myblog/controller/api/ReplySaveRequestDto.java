package com.douzone.myblog.controller.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplySaveRequestDto {
	private int userId;
	private int boardId;
	private String content;
}
