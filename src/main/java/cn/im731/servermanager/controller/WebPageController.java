package cn.im731.servermanager.controller;

import cn.im731.servermanager.bean.*;
import cn.im731.servermanager.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Controller
public class WebPageController {
    @Autowired
    ClientInfoMapper clientInfoMapper;

    @Autowired
    ClientStatusMapper clientStatusMapper;

    @Autowired
    ClientDetailMapper clientDetailMapper;

    //查询所有服务器，返回列表页面
    @GetMapping("/clients")
    public String list(Model model) {
        Collection<ClientDetail> allClientDetail = clientDetailMapper.getAllClientDetail();
        model.addAttribute("allClientDetail", allClientDetail);
        return "client/list";
    }

    //去client添加页面
    @GetMapping("/client")
    public String toAddPage() {

        return "client/add";
    }

    //client添加操作
    @PostMapping("/client")
    public String addServer(ClientInfo clientInfo) {
        //1.先存clientInfo
        System.out.println("1.要保存的clientInfo:"+clientInfo);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date()).toString();
        clientInfo.setAddTime(dateString);
        clientInfoMapper.insertClientInfo(clientInfo);

        //2.获得ID
        ClientInfo clientInfo1 = clientInfoMapper.getClientInfoByHostName(clientInfo.getHostName());
        ClientStatus clientStatus = new ClientStatus();
        clientStatus.setId(clientInfo1.getId());

        //3.再存Status
        clientStatusMapper.insertClientStatus(clientStatus);
        System.out.println("2.要保存的clientStatus:"+clientStatus);
        return "redirect:/clients";
    }

    //去server修改页面
    @GetMapping("/client/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        ClientInfo clientInfo = clientInfoMapper.getClientInfoById(id);
        if (clientInfo == null) {
            return "redirect:/clients";
        }
        model.addAttribute("clientInfo", clientInfo);
        return "client/add";
    }

    //client修改操作
    /////////////////////////////需要ModelAttribute，否则会有问题
    @PutMapping("/client")
    public String editServer(ClientInfo clientInfo) {
        System.out.println("要修改的client:"+clientInfo);
        clientInfoMapper.updateClientInfo(clientInfo);
        return "redirect:/clients";
    }

    //client删除操作
    @DeleteMapping("/client/{id}")
    public String deleteServer(@PathVariable("id") Integer id) {
        ClientInfo clientInfo = clientInfoMapper.getClientInfoById(id);
        if (clientInfo != null) {
            System.out.println("要删除的client:"+clientInfo);
            clientInfoMapper.deleteClientInfo(id);
            clientStatusMapper.deleteClientStatus(id);
        }
        return "redirect:/clients";
    }

    //进入server状态详情页面
    @GetMapping("/client/detail/{id}")
    public String serverDetail(@PathVariable("id") Integer id, Model model) {
        ClientDetail clientDetail = clientDetailMapper.getClientDetailById(id);
        model.addAttribute("clientDetail", clientDetail);
        System.out.println("要查询的clientDetail："+clientDetail);
        return "client/detail";
    }

    //响应ack
    @GetMapping("/client/ack/{type}/{id}")
    public String serverAck(@PathVariable("id") Integer id, @PathVariable("type") String type) {
        switch (type) {
            case "ip":
                clientInfoMapper.clientIpChangeAck(id);
                if (!type.equals("all"))
                    break;
            case "msg":
                clientStatusMapper.clientMsgAck(id);
                if (!type.equals("all"))
                    break;
        }

        return "redirect:/clients";
    }

}
