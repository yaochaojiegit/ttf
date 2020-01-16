package com.qf.pojo;

/**
*@author:老姚
*@date 2017年12月27日
*备注：
*/

public class PageNum {
	private int page;
	private int rows;
	private String search;
	private String sort;
	private String order;
	public PageNum() {
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
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
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
	@Override
	public String toString() {
		return "PageNum [page=" + page + ", rows=" + rows + ", search=" + search + ", sort=" + sort + ", order=" + order
				+ "]";
	}
	
}
