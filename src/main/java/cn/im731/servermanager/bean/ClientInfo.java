package cn.im731.servermanager.bean;

//Client的自有属性，除了每次上报的数据之外的属性
public class ClientInfo {
    private Integer id;
    private String name;
    private String hostName;
    private String descrb;
    private String addTime;
    private String ipLast;

    public ClientInfo() {
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hostName='" + hostName + '\'' +
                ", descrb='" + descrb + '\'' +
                ", addTime='" + addTime + '\'' +
                ", ipLast='" + ipLast + '\'' +
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

    public String getIpLast() {
        return ipLast;
    }

    public void setIpLast(String ipLast) {
        this.ipLast = ipLast;
    }
}
