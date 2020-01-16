package com.qf.pojo;

import java.io.Serializable;
import java.util.List;

public class UiPageNum implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int  total;
	private List<?> rows;
	
	public UiPageNum() {
		super();
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "UiPageNum [total=" + total + ", rows=" + rows + "]";
	}

	
}
