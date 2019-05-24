package cn.im731.servermanager.mapper;

import cn.im731.servermanager.bean.Server;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface ServerMapper {

    @Select("select * from servers")
    public Collection<Server> getAllServers();

    @Select("select * from servers where id=#{id}")
    public Server getServerById(Integer id);

    //插入新的server记录
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into servers(name, host_name, IP_now, IP_last, last_report_time, frp_config, temperature, descrb, msg) values(#{name},#{lastName},#{IPNow},#{IPLast},#{lastReportTime},#{frpConfig},#{temperature},#{descrb},#{msg})")
    public int insertServer(Server server);

    //从网页修改server名称等信息
    @Update("update servers set name=#{name}, descrb=#{descrb} where id=#{id}")
    public int updateServerFromWebPage(Server server);

    //从server发来的数据更新请求
    @Update("update servers set IP_now=#{IP_now}, last_report_time=#{lastReportTime}, frp_config=#{frpConfig}, temperature=#{temperature}, msg=#{msg}")
    public int updateServerFromClient(Server server);

    @Delete("delete from servers where id=#{id}")
    public int deleteServer(Integer id);

    @Select("select id from servers where host_name=#{hostName}")
    public Integer getIdFromHostName(String hostName);

}
