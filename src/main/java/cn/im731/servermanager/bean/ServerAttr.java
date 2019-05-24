package cn.im731.servermanager.bean;

public class ServerAttr {
    private Integer id;
    private String name;
    private String hostName;
    private String descrb;
    private String addTime;
    private String deadTime;

    public ServerAttr() {
    }


    public ServerAttr(Integer id, String name, String hostName, String descrb, String addTime, String deadTime) {
        this.id = id;
        this.name = name;
        this.hostName = hostName;
        this.descrb = descrb;
        this.addTime = addTime;
        this.deadTime = deadTime;
    }

    @Override
    public String toString() {
        return "ServerAttr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hostName='" + hostName + '\'' +
                ", descrb='" + descrb + '\'' +
                ", addTime='" + addTime + '\'' +
                ", deadTime='" + deadTime + '\'' +
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

    public String getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(String deadTime) {
        this.deadTime = deadTime;
    }
}
