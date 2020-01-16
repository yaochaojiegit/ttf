package com.qf.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String gender;//性别

    private Integer flag;//状态  0未激活   1 已激活  2.已删除

    private Integer role;//身份  0 普通用户  1.会员

    private String code;//注册码

    private int balance;//余额

    public User() {
		super();
	}

    public int getBalance() { return balance; }

    public void setBalance(int balance) { this.balance = balance; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", gender="
				+ gender + ", flag=" + flag + ", role=" + role + ", code=" + code + "]";
	}
    
}