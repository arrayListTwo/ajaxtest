package com.it.course.domain;

import java.util.List;

/**
 * 课程列表收到的json数据
 * 
 * @author IT
 *
 */
public class SectionHomeList {

	/**
	 * 是否已经是学员
	 */
	private boolean student;
	/**
	 * 课程列表实体类
	 */
	private List<SectionBean> sectionBean;

	public SectionHomeList() {
		super();
	}

	/**
	 * @param student
	 *            是否是学员
	 * @param sectionBean
	 *            课程列表实体类
	 */
	public SectionHomeList(boolean student, List<SectionBean> sectionBean) {
		super();
		this.student = student;
		this.sectionBean = sectionBean;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}

	public boolean getStudent() {
		return student;
	}

	public void setSectionList(List<SectionBean> sectionBean) {
		this.sectionBean = sectionBean;
	}

	public List<SectionBean> getSectionList() {
		return sectionBean;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SectionHomeList [student=" + student + ", sectionBean=" + sectionBean + "]";
	}

}