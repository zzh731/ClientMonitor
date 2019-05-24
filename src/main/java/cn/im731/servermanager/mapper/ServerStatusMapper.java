package cn.im731.servermanager.mapper;

import cn.im731.servermanager.bean.ServerStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Client上报的数据
 * id
 * IPNow
 * IPLast
 * reportTime
 * frpConfig
 * temperature
 * msg
 */
@Repository
@Mapper
public interface ServerStatusMapper {

    @Select("select * from server_status")
    public List<ServerStatus> getAllServerStatus();

    @Select("select * from server_status where id=#{id}")
    public ServerStatus getServerStatus(Integer id);

    @Insert("insert into server_status(id, name) values(#{id}, #{name})")
    public int insertServerStatus(ServerStatus serverStatus);

    //ACK for IP变化
    @Update("update server_status set ip_last= ip_now where id=#{id}")
    public int serverStatusAckForIpChange(Integer id);

    //ACK for msg
    @Update("update server_status set msg= '' where id=#{id}")
    public int serverStatusAckForMsg(Integer id);


}
