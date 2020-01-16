package com.qf.pojo;

import java.io.Serializable;

/**
*@author:老姚
*@date 2018年1月4日
*备注：
*/

public class EasyUiTreeNode  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; 
	private String text;
	private String state;
	public EasyUiTreeNode() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "EasyUiTreeNode [id=" + id + ", text=" + text + ", state=" + state + "]";
	}
	
}
