package com.it.course.domain;

/**
 * 课程下内容bean对象
 * 
 * @author IT
 *
 */
public class ItemBean {

	/**
	 * 图片地址
	 */
	private String itemImgPath;

	/**
	 * 音频地址
	 */
	private String itemAudioPath;

	/**
	 * 课程内容ID
	 */
	private String itemID;

	/**
	 * 课程内容备注
	 */
	private String itemRemarks;

	/**
	 * 课程内容标题
	 */
	private String itemName;

	public ItemBean() {
		super();
	}

	/**
	 * @param itemImgPath
	 * @param itemAudioPath
	 * @param itemID
	 * @param itemRemarks
	 * @param itemName
	 */
	public ItemBean(String itemImgPath, String itemAudioPath, String itemID, String itemRemarks, String itemName) {
		super();
		this.itemImgPath = itemImgPath;
		this.itemAudioPath = itemAudioPath;
		this.itemID = itemID;
		this.itemRemarks = itemRemarks;
		this.itemName = itemName;
	}

	/**
	 * @return the itemImgPath
	 */
	public String getItemImgPath() {
		return itemImgPath;
	}

	/**
	 * @param itemImgPath
	 *            the itemImgPath to set
	 */
	public void setItemImgPath(String itemImgPath) {
		this.itemImgPath = itemImgPath;
	}

	/**
	 * @return the itemAudioPath
	 */
	public String getItemAudioPath() {
		return itemAudioPath;
	}

	/**
	 * @param itemAudioPath
	 *            the itemAudioPath to set
	 */
	public void setItemAudioPath(String itemAudioPath) {
		this.itemAudioPath = itemAudioPath;
	}

	/**
	 * @return the itemID
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * @param itemID
	 *            the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the itemRemarks
	 */
	public String getItemRemarks() {
		return itemRemarks;
	}

	/**
	 * @param itemRemarks
	 *            the itemRemarks to set
	 */
	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemBean [itemImgPath=" + itemImgPath + ", itemAudioPath=" + itemAudioPath + ", itemID=" + itemID
				+ ", itemRemarks=" + itemRemarks + ", itemName=" + itemName + "]";
	}

}
