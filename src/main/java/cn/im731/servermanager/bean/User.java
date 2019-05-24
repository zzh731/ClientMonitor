package cn.im731.servermanager.bean;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String password;
    private Date lastLogin;
    private String serverList;
    private Date registDate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", lastLogin=" + lastLogin +
                ", serverList='" + serverList + '\'' +
                ", registDate=" + registDate +
                '}';
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
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getServerList() {
        return serverList;
    }

    public void setServerList(String serverList) {
        this.serverList = serverList;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public User() {
    }

    public User(String name, String password, Date lastLogin, String serverList, Date registDate) {
        this.name = name;
        this.password = password;
        this.lastLogin = lastLogin;
        this.serverList = serverList;
        this.registDate = registDate;
    }
}
