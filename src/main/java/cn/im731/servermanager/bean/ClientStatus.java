package cn.im731.servermanager.bean;

//Client每次上报的数据
public class ClientStatus {
    private Integer id;
    private String ipNow;
    private String lastReportTime;
    private String frpConfig;
    private String temperature;
    private String msg;

    public ClientStatus() {
    }

    @Override
    public String toString() {
        return "ClientStatus{" +
                "id=" + id +
                ", ipNow='" + ipNow + '\'' +
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

    public String getIpNow() {
        return ipNow;
    }

    public void setIpNow(String ipNow) {
        this.ipNow = ipNow;
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
