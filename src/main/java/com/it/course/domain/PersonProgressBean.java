package com.it.course.domain;

/**
 * 学员个人进度表
 * @author IT
 *
 */
public class PersonProgressBean {

	private int id;

	/**
	 * 学员身份唯一标识
	 */
	private String personID;

	/**
	 * 课程种类标识
	 */
	private String primaryID;

	/**
	 * 课程标识ID
	 */
	private String sectionID;

	/**
	 * 此课程已完成的节数
	 */
	private int itemFinished;

	/**
	 * 课程开始学习的时间
	 */
	private String startTime;

	/**
	 * 学完此课程，结束时间
	 */
	private String endTime;

	/**
	 * 课程考试成绩
	 */
	private int examScore;

	/**
	 * 无参构造函数
	 */
	public PersonProgressBean() {
		super();
	}

	/**
	 * @param id
	 * @param personID
	 *            学员身份唯一标识
	 * @param primaryID
	 *            课程种类标识
	 * @param sectionID
	 *            课程标识ID
	 * @param itemFinished
	 *            此课程已完成的节数
	 * @param startTime
	 *            课程开始学习的时间
	 * @param endTime
	 *            学完此课程，结束时间
	 * @param examScore
	 *            课程考试成绩
	 */
	public PersonProgressBean(int id, String personID, String primaryID, String sectionID, int itemFinished,
			String startTime, String endTime, int examScore) {
		super();
		this.id = id;
		this.personID = personID;
		this.primaryID = primaryID;
		this.sectionID = sectionID;
		this.itemFinished = itemFinished;
		this.startTime = startTime;
		this.endTime = endTime;
		this.examScore = examScore;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the personID
	 */
	public String getPersonID() {
		return personID;
	}

	/**
	 * @param personID
	 *            the personID to set
	 */
	public void setPersonID(String personID) {
		this.personID = personID;
	}

	/**
	 * @return the primaryID
	 */
	public String getPrimaryID() {
		return primaryID;
	}

	/**
	 * @param primaryID
	 *            the primaryID to set
	 */
	public void setPrimaryID(String primaryID) {
		this.primaryID = primaryID;
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
	 * @return the itemFinished
	 */
	public int getItemFinished() {
		return itemFinished;
	}

	/**
	 * @param itemFinished
	 *            the itemFinished to set
	 */
	public void setItemFinished(int itemFinished) {
		this.itemFinished = itemFinished;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
		return "PersonProgressBean [id=" + id + ", personID=" + personID + ", primaryID=" + primaryID + ", sectionID="
				+ sectionID + ", itemFinished=" + itemFinished + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", examScore=" + examScore + "]";
	}

}
