package com.qf.pojo;

public class CartKey {
    private Integer id;

    private Integer pid;

    public CartKey() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	@Override
	public String toString() {
		return "CartKey [id=" + id + ", pid=" + pid + "]";
	}
}