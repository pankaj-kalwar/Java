package com.beyondalgo.common.model;

import org.springframework.web.multipart.MultipartFile;

public class Employee {
	private int id;

	private MultipartFile multipartFile;

	public Employee() {
	}

	public Employee(int id, MultipartFile multipartFile) {
		super();
		this.id = id;
		this.multipartFile = multipartFile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
