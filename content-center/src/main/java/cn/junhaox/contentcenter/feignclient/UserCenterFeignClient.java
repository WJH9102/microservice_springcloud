package cn.junhaox.contentcenter.feignclient;

import cn.junhaox.contentcenter.config.UserCenterFeignConfiguration;
import cn.junhaox.contentcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

/**
 * @Author WJH
 * @Description
 * @date 2020/11/28 10:02
 * @Email ibytecode2020@gmail.com
 */
//@FeignClient(name = "user-center", configuration = UserCenterFeignConfiguration.class)
@FeignClient(name = "user-center")
public interface UserCenterFeignClient {

    /**
     * 请求 user-center 接口获取 User信息
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    UserDTO findById(@PathVariable Integer id);

}
