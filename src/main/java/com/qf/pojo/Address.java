package com.qf.pojo;

public class Address {
    private Integer id;

    private String name;

    private String phone;

    private Integer uid;

    private Integer level;

    private String detail;
    
    private Integer status;

    public Address() {
		super();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", phone=" + phone + ", uid=" + uid + ", level=" + level
				+ ", detail=" + detail + ", status=" + status + "]";
	}

	
    
}