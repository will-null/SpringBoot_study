package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IdbcControllor {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    public List<Map<String, Object>> qq() {
        String sql = "select * from sex";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.toString());
        return list;
    }

}
