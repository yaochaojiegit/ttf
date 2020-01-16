package com.qf.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dsna.util.images.ValidateCode;


/**
*@author:老姚
*@date 2018年1月11日
*备注：
*/
@Controller
public class CodeController {

	@RequestMapping("/Code")
	@ResponseBody
	public void r(HttpServletResponse response,HttpSession session){
		ValidateCode code=new ValidateCode(80, 32, 4, 10);
		String string=code.getCode();
		System.out.println(string);
		session.setAttribute("code", string);
		try {
			code.write(response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
