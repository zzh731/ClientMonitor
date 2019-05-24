package cn.im731.servermanager.controller;

import cn.im731.servermanager.bean.ClientInfo;
import cn.im731.servermanager.bean.ClientStatus;
import cn.im731.servermanager.mapper.ClientInfoMapper;
import cn.im731.servermanager.mapper.ClientStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientReportController {

    @Autowired
    ClientInfoMapper clientInfoMapper;

    @Autowired
    ClientStatusMapper clientStatusMapper;

    //Client根据HostName获得id
    @ResponseBody
    @RequestMapping("/server/getID/{hostName}")
    public String getIdFromHostName(@PathVariable("hostName") String hostName) {
        Integer id;
        ClientInfo clientInfoGet = clientInfoMapper.getClientInfoByHostName(hostName);
        if (clientInfoGet == null) {//若空，则先创建记录，在info表和status表各创建一条记录
            //获取时间
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timeString = simpleDateFormat.format(new Date()).toString();

            //先在attr表添加一条记录
            ClientInfo clientInfo = new ClientInfo();
            clientInfo.setName(hostName);//name默认是hostName,用户可以自己修改
            clientInfo.setHostName(hostName);
            clientInfo.setDescrb("由client直接创建");
            clientInfo.setAddTime(timeString);
            clientInfoMapper.insertClientInfo(clientInfo);

            //然后获取id(id是数据库自动生成的)
            clientInfoGet = clientInfoMapper.getClientInfoByHostName(hostName);
            id = clientInfoGet.getId();

            //再在status表添加一条记录
            ClientStatus clientStatus = new ClientStatus();
            clientStatus.setId(id);
            clientStatusMapper.insertClientStatus(clientStatus);
        }
        id = clientInfoGet.getId();
        return id+"";
    }

    //Client根据id上报数据
    @ResponseBody
    @RequestMapping("/server/report")
    public String updateDataFromClient() {

        return "OK";
    }
}
