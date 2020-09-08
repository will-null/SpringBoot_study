package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/u")
public class IdbcControllor {

    /*  @Autowired
      JdbcTemplate jdbcTemplate;

      @ResponseBody
      public List<Map<String, Object>> qq() {
          String sql = "select * from sex";
          List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
          System.out.println(list.toString());
          return list;
      }
  */
    @Autowired
    UserService userService;

    @GetMapping("/wo")
    public User findById() {
        User user = userService.findById();
        return user;
    }
}
