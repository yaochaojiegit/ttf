package com.qf.pojo;

public class OrderDetail {
    private Integer id;

    private String oid;

    private Integer pid;

    private Integer num;

    private Integer money;

    private String gName;//商品名称

    private String time;//时间

    private int status;//支付状态

    public String getgName() { return gName; }

    public String getTime() { return time; }

    public int getStatus() { return status; }

    public void setTime(String time) { this.time = time; }

    public void setStatus(int status) { this.status = status; }

    public void setgName(String gName) { this.gName = gName; }

    public OrderDetail() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", oid=" + oid + ", pid=" + pid + ", num=" + num + ", money=" + money + "]";
	}
}