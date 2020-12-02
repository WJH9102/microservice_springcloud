package cn.junhaox.usercenter.service;

import cn.junhaox.usercenter.dao.user.UserMapper;
import cn.junhaox.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author WJH
 * @Description
 * @date 2020/11/27 9:13
 * @Email ibytecode2020@gmail.com
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserMapper userMapper;

    public User findById(Integer id) {
        // select * from user where id = #{id}
        return this.userMapper.selectByPrimaryKey(id);
    }

}
