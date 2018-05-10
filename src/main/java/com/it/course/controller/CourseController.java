package com.it.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.it.course.domain.SpecifiedItemBean;
import com.it.course.service.CurriculaService;

@Controller
@RequestMapping(value = "/curricula")
public class CourseController {

	@Autowired
	CurriculaService curriculaService;

	/**
	 * 返回课程列表页面
	 */
	@RequestMapping(value = "/index")
	public ModelAndView courseIndex() {
		return new ModelAndView("/WEB-INF/course/course_top.html");
	}

	/**
	 * 课程列表页面获取学习进度详细情况
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sectionList")
	@ResponseBody
	public String getSectionList() {
		String resultOfJson = curriculaService.getSectionListFromSql("test");
		return resultOfJson;
	}

	/**
	 * 跳转到指定课程的内容学习
	 * 
	 * @param specifiedItemBean
	 *            跳转课程内容所需信息对象
	 * @return 课程内容json字符串
	 */
	@RequestMapping(value = "/specified", method = RequestMethod.POST)
	@ResponseBody
	public String enterSpecifiedItem(@RequestBody SpecifiedItemBean specifiedItemBean) {
		// 下一个课程
		int nextItem = Integer.parseInt(specifiedItemBean.getFinishedItem() + 1);
		if(nextItem > Integer.parseInt(specifiedItemBean.getTotalItem())){ // 当前课程是否已学习完毕
			nextItem = 1;
		}
		String resultOfItem = curriculaService.getCurriculaItemFromSql("test", specifiedItemBean.getSectionID(), nextItem);
		return resultOfItem;
	}

}
