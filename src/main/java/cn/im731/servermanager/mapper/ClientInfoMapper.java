package cn.im731.servermanager.mapper;

import cn.im731.servermanager.bean.ClientInfo;
import cn.im731.servermanager.bean.ServerAttr;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Client的属性
 * id:id
 * name:主机名字，自己起的，可以改
 * hostName:主机名，获取的，固定不变
 * descrb:描述，可以改
 * add_time:主机添加时间
 * dead_time:主机死亡时间
 */

@Repository
@Mapper
public interface ClientInfoMapper {

    @Select("select * from client_info")
    public Collection<ClientInfo> getAllClientInfo();

    @Select("select * from client_info where id=#{id}")
    public ClientInfo getClientInfoById(Integer id);

    @Select("select * from client_info where host_name=#{hostName}")
    public ClientInfo getClientInfoByHostName(String hostName);

    //web页面新增
    //Cient插入
    @Insert("insert into client_info(name, host_name, add_time, descrb, ip_last) values(#{name}, #{hostName}, #{addTime}, #{descrb}, ip_last=#{ipLast})")
    public int insertClientInfo(ClientInfo clientInfo);

    //Web页面修改
    @Update("update client_info set name=#{name}, host_name=#{hostName}, descrb=#{descrb}, add_time=#{addTime}, ip_last=#{ipLast}")
//    @Update("update client_info set name=#{name}, host_name=#{hostName}, descrb=#{descrb}, add_time=#{addTime}, ip_last=#{ip} where id=#{id}")
    public int updateClientInfo(ClientInfo clientInfo);

    @Delete("delete from client_info where id=#{id}")
    public int deleteClientInfo(Integer id);

    //ACK for IP变化
    @Update("update client_info set ip_last=(select ip_now from client_status where id=#{id}) where id=#{id}")
    public int clientIpChangeAck(Integer id);

}
