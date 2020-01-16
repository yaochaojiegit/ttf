package com.qf.pojo;

public class Cart extends CartKey {
    private Integer num;

    private Integer money;

    public Cart() {
		super();
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
		return "Cart [num=" + num + ", money=" + money + "]";
	}
}