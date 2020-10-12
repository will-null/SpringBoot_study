package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface UserMapper extends Mapper {

    @Cacheable(cacheNames = "User:Id", key = "#p0")
    @Select("SELECT * FROM mysql_user WHERE id=#{idu}")
    User findById(@Param("idu") String id);
}
