package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends Mapper{
    @Select("SELECT * FROM mysql_user")
    User findById();
}
