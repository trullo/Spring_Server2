package com.java.Spring_Server2.file.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.java.Spring_Server2.util.HttpUtil;


@Controller
public class FileController {
	
	@Autowired
	com.java.Spring_Server2.file.service.FileServiceInterface fsi;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@RequestMapping("/FileUpload/{dir}")
	public void fileUpload(@RequestParam("file") MultipartFile[] files, @PathVariable("dir") String dir, HttpServletRequest req, HttpServletResponse res) {
		//@RequestParam(파라미터이름) 담을 변수 : request파라미터값을 담아주는 변수
		HttpUtil.makeJsonWriter(res, fsi.fileUpload(files, dir, req));
		//makeJsonWriter(HttpServletResponse res, HashMap<String, Object> map)
		// HashMap<String, Object> fileUpload(MultipartFile[] files, String dir, HttpServletRequest req)
	}
}
