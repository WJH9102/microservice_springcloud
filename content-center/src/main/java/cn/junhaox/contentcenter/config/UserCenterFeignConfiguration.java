package cn.junhaox.contentcenter.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Author WJH
 * @Description
 * @date 2020/11/28 10:29
 * @Email ibytecode2020@gmail.com
 */
public class UserCenterFeignConfiguration {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

}
