package com.qf.pojo;


public class Order {
    private String id;

    private Integer uid;//用户外键
    
    private String uname;//用户姓名

    private Integer money;

    private int status;//订单状态 0提交未处理  1 已处理  2取消/删除

    private String date;//用户时间

    private Integer aid;//地址外键
    
    private String address;//用户地址

    public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Order() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
        date = date.substring(0,date.length() - 2);
		this.date = date;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status ; }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", uname=" + uname + ", money=" + money + ", status=" + status
				+ ", date=" + date + ", aid=" + aid + ", address=" + address + "]";
	}

}