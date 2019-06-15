package com.whm.First_SpringBoot_M3.entity;

public class Users {
    private Integer uid;

    private String username;

    private String realname;

    private String password;

    private Integer usalary;

    private String udate;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUsalary() {
        return usalary;
    }

    public void setUsalary(Integer usalary) {
        this.usalary = usalary;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate == null ? null : udate.trim();
    }

	public Users(Integer uid, String username, String realname, String password, Integer usalary, String udate) {
		super();
		this.uid = uid;
		this.username = username;
		this.realname = realname;
		this.password = password;
		this.usalary = usalary;
		this.udate = udate;
	}
//***********在自己写构造函数时，一定要实现初始化的构造函数
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
    


}