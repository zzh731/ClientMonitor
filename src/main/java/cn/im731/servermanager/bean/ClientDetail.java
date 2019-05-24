package cn.im731.servermanager.bean;

//整合info和status，用于list显示
public class ClientDetail {
    private Integer id;
    private String name;
    private String hostName;
    private String descrb;
    private String addTime;
    private String ipNow;

    private String ipLast;
    private String lastReportTime;
    private String frpConfig;
    private String temperature;
    private String msg;

    public ClientDetail() {
    }

    public ClientDetail(Integer id, String name, String hostName, String descrb, String addTime, String ipNow, String ipLast, String lastReportTime, String frpConfig, String temperature, String msg) {
        this.id = id;
        this.name = name;
        this.hostName = hostName;
        this.descrb = descrb;
        this.addTime = addTime;
        this.ipNow = ipNow;
        this.ipLast = ipLast;
        this.lastReportTime = lastReportTime;
        this.frpConfig = frpConfig;
        this.temperature = temperature;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ClientDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hostName='" + hostName + '\'' +
                ", descrb='" + descrb + '\'' +
                ", addTime='" + addTime + '\'' +
                ", ipNow='" + ipNow + '\'' +
                ", ipLast='" + ipLast + '\'' +
                ", lastReportTime='" + lastReportTime + '\'' +
                ", frpConfig='" + frpConfig + '\'' +
                ", temperature='" + temperature + '\'' +
                ", msg='" + msg + '\'' +
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

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDescrb() {
        return descrb;
    }

    public void setDescrb(String descrb) {
        this.descrb = descrb;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getIpNow() {
        return ipNow;
    }

    public void setIpNow(String ipNow) {
        this.ipNow = ipNow;
    }

    public String getIpLast() {
        return ipLast;
    }

    public void setIpLast(String ipLast) {
        this.ipLast = ipLast;
    }

    public String getLastReportTime() {
        return lastReportTime;
    }

    public void setLastReportTime(String lastReportTime) {
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
