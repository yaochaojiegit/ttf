package com.qf.pojo;

/**
*@author:老姚
*@date 2017年12月29日
*备注：
*/

public class UINum {
	int page=1;
	int rows=10;
	String sort;
	String order;
	String title;
	String species;
	public UINum() {
		super();
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	@Override
	public String toString() {
		return "UINum [page=" + page + ", rows=" + rows + ", sort=" + sort + ", order=" + order + ", title=" + title
				+ ", species=" + species + "]";
	}
	
}
