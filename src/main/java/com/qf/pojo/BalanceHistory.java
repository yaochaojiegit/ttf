package com.qf.pojo;

import java.util.Date;

/**
 * create by 姚超杰 by 2018/4/25
 * 备注:充值退款
 */
public class BalanceHistory {
    private Integer id;
    private Integer uid;
    private Integer type;//0退款  1充值 2订单购买
    private Integer money;
    private Integer beforeBalance;//变化前余额
    private Integer afterBalance;//变化后余额
    private Date  time;//时间
    private String datime;

    public String getDatime() {
        return datime;
    }

    public void setDatime(String datime) {
        this.datime = datime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setBeforeBalance(Integer beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    public void setAfterBalance(Integer afterBalance) {
        this.afterBalance = afterBalance;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getId() {

        return id;
    }

    public Integer getUid() {
        return uid;
    }

    public Integer getType() {
        return type;
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getBeforeBalance() {
        return beforeBalance;
    }

    public Integer getAfterBalance() {
        return afterBalance;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "BalanceHistory{" +
                "id=" + id +
                ", uid=" + uid +
                ", type=" + type +
                ", money=" + money +
                ", beforeBalance=" + beforeBalance +
                ", afterBalance=" + afterBalance +
                ", time=" + time +
                '}';
    }
}
