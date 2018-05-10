package com.it.course.domain;

/**
 * 跳转到指定课程内容时所需信息
 * 
 * @author IT
 *
 */
public class SpecifiedItemBean {

	/**
	 * 课程标识ID
	 */
	private String sectionID;

	/**
	 * 本课程已完成内容数
	 */
	private String finishedItem;

	/**
	 * 本课程共计多少内容数
	 */
	private String totalItem;

	public SpecifiedItemBean() {
		super();
	}

	/**
	 * @param sectionID
	 * @param finishedItem
	 * @param totalItem
	 */
	public SpecifiedItemBean(String sectionID, String finishedItem, String totalItem) {
		super();
		this.sectionID = sectionID;
		this.finishedItem = finishedItem;
		this.totalItem = totalItem;
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
	 * @return the finishedItem
	 */
	public String getFinishedItem() {
		return finishedItem;
	}

	/**
	 * @param finishedItem
	 *            the finishedItem to set
	 */
	public void setFinishedItem(String finishedItem) {
		this.finishedItem = finishedItem;
	}

	/**
	 * @return the totalItem
	 */
	public String getTotalItem() {
		return totalItem;
	}

	/**
	 * @param totalItem
	 *            the totalItem to set
	 */
	public void setTotalItem(String totalItem) {
		this.totalItem = totalItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SpecifiedItemBean [sectionID=" + sectionID + ", finishedItem=" + finishedItem + ", totalItem="
				+ totalItem + "]";
	}

}
