package com.sishuok.spring.entity;

import java.io.Serializable;


/**
 *
 *
 * @author ucar
 * @email ucar@gmail.com
 * @date 2018-07-04 14:07:48
 */
public class SysDictionaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "SysDictionaryEntity{" +
				"id=" + id +
				", sn='" + sn + '\'' +
				", title='" + title + '\'' +
				", intro='" + intro + '\'' +
				", category='" + category + '\'' +
				", isPrivate=" + isPrivate +
				", projectId=" + projectId +
				'}';
	}

	//主键ID
	private Long id;
	//编码
	private String sn;
	//标题
	private String title;
	//简介
	private String intro;
	//类别
	private String category;
	//是否私有
	private int isPrivate;
	//项目Id
	private int projectId;
    //供展示用字段
	/**
	 * 设置：主键ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：编码
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}
	/**
	 * 获取：编码
	 */
	public String getSn() {
		return sn;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：简介
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * 获取：简介
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * 设置：类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：类别
	 */
	public String getCategory() {
		return category;
	}

	public int getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(int isPrivate) {
		this.isPrivate = isPrivate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
