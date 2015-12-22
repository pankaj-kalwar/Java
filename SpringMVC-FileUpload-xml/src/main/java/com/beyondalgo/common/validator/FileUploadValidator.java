package com.beyondalgo.common.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.beyondalgo.common.model.Employee;

public class FileUploadValidator implements Validator{

	@SuppressWarnings("rawtypes")
	public boolean supports(Class clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Employee employee = (Employee)target;
		if(employee.getMultipartFile().getSize() == 0){
			errors.rejectValue("file", "required.fileUpload");
		}
	}

}
