package com.task.service.impl;

import com.task.service.TaskService;

public class TaskServiceImpl implements TaskService {

	@Override
	public void run() {
		System.out.println("定时器运行正常");
	}

}
