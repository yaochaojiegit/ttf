package com.qf.pojo;

/**
*@author:老姚
*@date 2017年12月29日
*备注：
*/

public class UINum2 {
	int page=1;
	int rows=10;
	String sort;
	String order;
	String title;
	String species;
	String species2;
	String species3;
	public UINum2() {
		super();
	}
	public String getSpecies3() { return species3; }
	public void setSpecies3(String species3) { this.species3 = species3; }
	public String getSpecies2() {
		return species2;
	}
	public void setSpecies2(String species2) {
		this.species2 = species2;
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
		return "UINum2 [page=" + page + ", rows=" + rows + ", sort=" + sort + ", order=" + order + ", title=" + title
				+ ", species=" + species + ", species2=" + species2 + "]";
	}
	
	
}
