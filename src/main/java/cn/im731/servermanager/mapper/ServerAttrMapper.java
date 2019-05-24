package cn.im731.servermanager.mapper;

import cn.im731.servermanager.bean.Server;
import cn.im731.servermanager.bean.ServerAttr;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

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
public interface ServerAttrMapper {

    @Select("select * from server_attr")
    public Collection<ServerAttr> getAllServerAttrs();

    @Select("select * from server_attr where id=#{id}")
    public ServerAttr getServerAttrById(Integer id);

    @Select("select * from server_attr where host_name=#{hostName}")
    public ServerAttr getServerAttrByHostName(String hostName);

    //web页面新增
    //Cient插入
    @Insert("insert into server_attr(name, host_name, add_time, descrb) values(#{name}, #{hostName}, #{addTime}, #{descrb})")
    public int insertServerAttr(ServerAttr serverAttr);

    //Web页面修改
    @Update("update server_attr set name=#{name}, host_name=#{hostName}, add_time=#{addTime}")
    public int updateServerAttr(ServerAttr serverAttr);

    @Delete("delete from server_attr where id=#{id}")
    public int deleteServerAttr(Integer id);

}
