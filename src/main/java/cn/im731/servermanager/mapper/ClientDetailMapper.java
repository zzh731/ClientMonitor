package cn.im731.servermanager.mapper;

import cn.im731.servermanager.bean.ClientDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Mapper
public interface ClientDetailMapper {

    @Select("select * from client_info info, client_status status where info.id=status.id")
    public Collection<ClientDetail> getAllClientDetail();

    @Select("select * from client_info info, client_status status where info.id=status.id and info.id=#{id}")
    public ClientDetail getClientDetailById(Integer id);
}
