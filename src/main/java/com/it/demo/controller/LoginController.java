package com.it.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.it.demo.service.LoginService;

@Controller
public class LoginController {

	@Resource
	LoginService service;

	@Resource
	HttpServletRequest request;

	@RequestMapping("index")
	public ModelAndView toLoginPage() {
		return new ModelAndView("WEB-INF/jsp/json_test.jsp");
	}
	
	@RequestMapping("jsonTest")
	public ModelAndView jsonTest() {
		return new ModelAndView("WEB-INF/jsp/ajaxStart.jsp");
	}

	@RequestMapping("login")
	public ModelAndView doLogin() {
		String loginPageUrl = "WEB-INF/jsp/login.jsp";
		String successPageUrl = "WEB-INF/jsp/success.jsp";

		String uname = request.getParameter("uname");
		String upasswd = request.getParameter("upasswd");

		return service.doLogin(loginPageUrl, successPageUrl, uname, upasswd);
	}

	@RequestMapping(value = "dopost", method = RequestMethod.POST)
	@ResponseBody
	public String doAjaxPost() {
		// 获取post方式提交过来的数据
		String num = request.getParameter("num");
		System.out.println(num);
		Gson gson = new Gson();
		Person person = new Person("5中文");
		System.out.println(gson.toJson(person));
		// 返回json格式数据(含有中文)
		return gson.toJson(person);
	}

	class Person {
		String nature;

		public Person(String nature) {
			super();
			this.nature = nature;
		}

		public String getNature() {
			return nature;
		}

		public void setNature(String nature) {
			this.nature = nature;
		}

	}

}
