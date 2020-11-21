package cn.junhaox.usercenter.controller;

import cn.junhaox.usercenter.dao.user.UserMapper;
import cn.junhaox.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author WJH
 * @Description
 * @date 2020/11/21 16:24
 * @Email ibytecode2020@gmail.com
 */
@RestController
public class TestController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/test")
    public User test() {
        User user = new User();
        user.setAvatarUrl("xxx");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);
        return user;
    }

}
