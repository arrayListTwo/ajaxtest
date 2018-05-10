package com.it.course.domain;

/**
 * 课程列表首页显示的课程bean类
 * 
 * @author IT
 *
 */
public class SectionBean {

	/**
	 * 课程标识ID
	 */
	private String sectionID;

	/**
	 * 课程名称
	 */
	private String sectionName;

	/**
	 * 课程一共几节
	 */
	private int totalItem;

	/**
	 * 已完成本课程节数
	 */
	private int finishedItem;

	/**
	 * 课程背景图片
	 */
	private String sectionImgPath;

	/**
	 * 考试分数
	 */
	private int examScore;

	/**
	 * 无参构造函数
	 */
	public SectionBean() {
		super();
	}

	/**
	 * @param sectionID
	 *            课程标识ID
	 * @param sectionName
	 *            课程名称
	 * @param totalItem
	 *            课程一共几节
	 * @param finishedItem
	 *            已完成本课程节数
	 * @param sectionImgPath
	 *            课程背景图片
	 * @param examScore
	 *            考试分数
	 */
	public SectionBean(String sectionID, String sectionName, int totalItem, int finishedItem,
			String sectionImgPath, int examScore) {
		super();
		this.sectionID = sectionID;
		this.sectionName = sectionName;
		this.totalItem = totalItem;
		this.finishedItem = finishedItem;
		this.sectionImgPath = sectionImgPath;
		this.examScore = examScore;
	}

	/**
	 * @return the sectionID
	 */
	public String getSectionID() {
		return sectionID;
	}

	/**
	 * @param sectionID
	 *            the sectionID to set
	 */
	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}

	/**
	 * @return the sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName
	 *            the sectionName to set
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @return the totalItem
	 */
	public int getTotalItem() {
		return totalItem;
	}

	/**
	 * @param totalItem
	 *            the totalItem to set
	 */
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	/**
	 * @return the finishedItem
	 */
	public int getFinishedItem() {
		return finishedItem;
	}

	/**
	 * @param finishedItem
	 *            the finishedItem to set
	 */
	public void setFinishedItem(int finishedItem) {
		this.finishedItem = finishedItem;
	}

	/**
	 * @return the sectionImgPath
	 */
	public String getSectionImgPath() {
		return sectionImgPath;
	}

	/**
	 * @param sectionImgPath
	 *            the sectionImgPath to set
	 */
	public void setSectionImgPath(String sectionImgPath) {
		this.sectionImgPath = sectionImgPath;
	}

	/**
	 * @return the examScore
	 */
	public int getExamScore() {
		return examScore;
	}

	/**
	 * @param examScore
	 *            the examScore to set
	 */
	public void setExamScore(int examScore) {
		this.examScore = examScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SectionBean [sectionID=" + sectionID + ", sectionName=" + sectionName + ", totalItem=" + totalItem
				+ ", finishedItem=" + finishedItem + ", sectionImgPath=" + sectionImgPath + ", examScore=" + examScore
				+ "]";
	}

}
