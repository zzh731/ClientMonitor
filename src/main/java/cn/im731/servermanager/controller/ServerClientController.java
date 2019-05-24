package cn.im731.servermanager.controller;

import cn.im731.servermanager.bean.Server;
import cn.im731.servermanager.bean.ServerAttr;
import cn.im731.servermanager.bean.ServerStatus;
import cn.im731.servermanager.mapper.ServerAttrMapper;
import cn.im731.servermanager.mapper.ServerStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerClientController {

    @Autowired
    ServerAttrMapper serverAttrMapper;

    @Autowired
    ServerStatusMapper serverStatusMapper;

    //Client根据HostName获得id
    @ResponseBody
    @RequestMapping("/server/getID/{hostName}")
    public String getIdFromHostName(@PathVariable("hostName") String hostName) {
        Integer id;
        ServerAttr serverAttrGet= serverAttrMapper.getServerAttrByHostName(hostName);
        if (serverAttrGet == null) {//若空，则先创建记录，在attr表和status表各创建一条记录
            //获取时间
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = simpleDateFormat.format(new Date()).toString();

            //先在attr表添加一条记录
            ServerAttr serverAttr = new ServerAttr();
            serverAttr.setName(hostName);//name默认是hostName,用户可以自己修改
            serverAttr.setHostName(hostName);
            serverAttr.setDescrb("由client直接创建");
            serverAttr.setAddTime(dateString);
            serverAttrMapper.insertServerAttr(serverAttr);

            //然后获取id(id是数据库自动生成的)
            serverAttrGet= serverAttrMapper.getServerAttrByHostName(hostName);
            id = serverAttrGet.getId();

            //再在status表添加一条记录
            ServerStatus serverStatus = new ServerStatus();
            serverStatus.setId(id);
            serverStatus.setName(hostName);
            serverStatusMapper.insertServerStatus(serverStatus);
        }
        id = serverAttrGet.getId();
        return id+"";
    }

    //Client根据id上报数据
    @ResponseBody
    @RequestMapping("/server/report")
    public String updateDataFromClient() {

        return "OK";
    }
}
