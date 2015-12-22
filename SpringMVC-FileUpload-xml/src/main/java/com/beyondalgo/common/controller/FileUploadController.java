package com.beyondalgo.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.beyondalgo.common.model.Employee;

public class FileUploadController extends SimpleFormController {
	public FileUploadController() {
		setCommandClass(Employee.class);
		setCommandName("fileUploadForm");
	}

	/**
	 * If you are using byte[] for uploading a file than you have to override
	 * the initbinder
	 * */

	/*@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws ServletException {

		// Convert multipart object to byte[]
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());

	}*/

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		Employee file = (Employee) command;

		MultipartFile multipartFile = file.getMultipartFile();

		String fileName = "";

		if (multipartFile != null) {
			fileName = multipartFile.getOriginalFilename();
			// do whatever you want
		}

		return new ModelAndView("FileUploadSuccess", "fileName", fileName);
	}
}
