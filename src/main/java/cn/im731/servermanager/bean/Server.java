package cn.im731.servermanager.bean;

import java.util.Date;

public class Server {
    private Integer id;
    private String name;
    private String hostName;
    private String IPNow;
    private String IPLast;
    private String msg;
    private Date lastReportTime;
    private String frpConfig;
    private String temperature;
    private String descrb;

    public Server(Integer id, String name, String hostName, String IPNow, String IPLast, String msg, Date lastReportTime, String frpConfig, String temperature, String descrb) {
        this.id = id;
        this.name = name;
        this.hostName = hostName;
        this.IPNow = IPNow;
        this.IPLast = IPLast;
        this.msg = msg;
        this.lastReportTime = lastReportTime;
        this.frpConfig = frpConfig;
        this.temperature = temperature;
        this.descrb = descrb;
    }

    public Server(String hostName) {
        this.hostName = hostName;
    }

    public String getIPLast() {
        return IPLast;
    }

    public void setIPLast(String IPLast) {
        this.IPLast = IPLast;
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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIPNow() {
        return IPNow;
    }

    public void setIPNow(String IPNow) {
        this.IPNow = IPNow;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getLastReportTime() {
        return lastReportTime;
    }

    public void setLastReportTime(Date lastReportTime) {
        this.lastReportTime = lastReportTime;
    }

    public String getFrpConfig() {
        return frpConfig;
    }

    public void setFrpConfig(String frpConfig) {
        this.frpConfig = frpConfig;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDescrb() {
        return descrb;
    }

    public void setDescrb(String descrb) {
        this.descrb = descrb;
    }

    public Server() {
    }

}
