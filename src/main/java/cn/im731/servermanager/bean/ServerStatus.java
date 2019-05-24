package cn.im731.servermanager.bean;

public class ServerStatus {
    private Integer id;
    private String name;
    private String IPNow;
    private String IPLast;
    private String reportTime;
    private String frpConfig;
    private String temperature;
    private String msg;

    public ServerStatus() {
    }

    public ServerStatus(Integer id, String name, String IPNow, String IPLast, String reportTime, String frpConfig, String temperature, String msg) {
        this.id = id;
        this.name = name;
        this.IPNow = IPNow;
        this.IPLast = IPLast;
        this.reportTime = reportTime;
        this.frpConfig = frpConfig;
        this.temperature = temperature;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServerStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", IPNow='" + IPNow + '\'' +
                ", IPLast='" + IPLast + '\'' +
                ", reportTime='" + reportTime + '\'' +
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

    public String getIPNow() {
        return IPNow;
    }

    public void setIPNow(String IPNow) {
        this.IPNow = IPNow;
    }

    public String getIPLast() {
        return IPLast;
    }

    public void setIPLast(String IPLast) {
        this.IPLast = IPLast;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
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
