package cn.im731.servermanager.controller;

import cn.im731.servermanager.bean.ServerAttr;
import cn.im731.servermanager.bean.ServerStatus;
import cn.im731.servermanager.mapper.ServerAttrMapper;
import cn.im731.servermanager.mapper.ServerStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class ServerWebPageController {
    @Autowired
    ServerAttrMapper serverAttrMapper;

    @Autowired
    ServerStatusMapper serverStatusMapper;

    //查询所有服务器，返回列表页面
    @GetMapping("/servers")
    public String list(Model model) {
        Collection<ServerStatus> serverStatuses = serverStatusMapper.getAllServerStatus();

        model.addAttribute("serverStatuses", serverStatuses);
        return "server/list";
    }

    //去server添加页面
    @GetMapping("/server")
    public String toAddPage() {

        return "server/add";
    }

    //server添加操作
    @PostMapping("/server")
    public String addServer(ServerAttr serverAttr) {
        //1.先存serverAttr
        System.out.println("1.要保存的ServerAttr:"+serverAttr);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date()).toString();
        serverAttr.setAddTime(dateString);
        serverAttrMapper.insertServerAttr(serverAttr);

        //2.获得ID
        ServerAttr serverAttr1 = serverAttrMapper.getServerAttrByHostName(serverAttr.getHostName());
        ServerStatus serverStatus = new ServerStatus();
        serverStatus.setId(serverAttr1.getId());
        serverStatus.setName(serverAttr1.getName());

        //3.再存serverStatus
        serverStatusMapper.insertServerStatus(serverStatus);
        System.out.println("2.要保存的ServerStatus:"+serverStatus);
        return "redirect:/servers";
    }

    //去server修改页面
    @GetMapping("/server/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        ServerAttr serverAttr = serverAttrMapper.getServerAttrById(id);
        if (serverAttr == null) {
            return "redirect:/servers";
        }
        model.addAttribute("serverAttr", serverAttr);
        return "server/add";
    }

    //server修改操作
    @PutMapping("/server")
    public String editServer(ServerAttr serverAttr) {
        System.out.println("要修改的Server:"+serverAttr);
        serverAttrMapper.updateServerAttr(serverAttr);
        return "redirect:/servers";
    }

    //server删除操作
    @DeleteMapping("/server/{id}")
    public String deleteServer(@PathVariable("id") Integer id) {
        ServerAttr serverAttr = serverAttrMapper.getServerAttrById(id);
        if (serverAttr == null) {
            return "redirect:/servers";
        }
        System.out.println("要删除的server:"+serverAttr);
        serverAttrMapper.deleteServerAttr(id);
        return "redirect:/servers";
    }

    //进入server状态详情页面
    @GetMapping("/server/detail/{id}")
    public String serverDetail(@PathVariable("id") Integer id, Model model) {
        ServerAttr serverAttr = serverAttrMapper.getServerAttrById(id);
        ServerStatus serverStatus = serverStatusMapper.getServerStatus(id);
        model.addAttribute("serverAttr", serverAttr);
        model.addAttribute("serverStatus", serverStatus);
        System.out.println("查看id="+id+"的属性："+serverAttr);
        System.out.println("查看id="+id+"的详情："+serverStatus);
        return "server/detail";
    }

    //响应ack
    @GetMapping("/server/ack/{type}/{id}")
    public String serverAck(@PathVariable("id") Integer id, @PathVariable("type") String type) {
        switch (type) {
            case "ip":
                serverStatusMapper.serverStatusAckForIpChange(id);
                if (!type.equals("all"))
                    break;
            case "msg":
                serverStatusMapper.serverStatusAckForMsg(id);
                if (!type.equals("all"))
                    break;
        }

        return "redirect:/servers";
    }

}
