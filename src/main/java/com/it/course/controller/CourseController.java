package com.it.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {

	@RequestMapping(value = "course/index")
	public ModelAndView courseIndex() {
		return new ModelAndView("/WEB-INF/course/course_top.html");
	}

}
