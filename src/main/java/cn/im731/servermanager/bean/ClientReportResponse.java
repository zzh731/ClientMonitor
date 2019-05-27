package cn.im731.servermanager.bean;

public class ClientReportResponse {
    private Integer code;
    private String status;
    private String msg;

    public ClientReportResponse() {
    }

    public ClientReportResponse(Integer code, String status, String msg) {
        this.code = code;
        this.status = status;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ClientReportResponse{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
