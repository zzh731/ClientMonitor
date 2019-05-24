package cn.im731.servermanager.mapper;

import cn.im731.servermanager.bean.ClientStatus;
import cn.im731.servermanager.bean.ServerStatus;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClientStatusMapper {

    @Select("select * from client_status")
    public List<ClientStatus> getAllServerStatus();

    @Select("select * from client_status where id=#{id}")
    public ClientStatus getClientStatusById(Integer id);

    @Insert("insert into client_status(id, ip_now, last_report_time, frp_config, temperature, msg) values(#{id}, #{ipNow}, #{lastReportTime}, #{frpConfig} , #{temperature} , #{msg})")
    public int insertClientStatus(ClientStatus clientStatus);

    //ACK for msg
    @Update("update client_status set msg=null where id=#{id}")
    public int clientMsgAck(Integer id);

    @Delete("delete from client_status where id=#{id}")
    public int deleteClientStatus(Integer id);


}
