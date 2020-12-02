package cn.junhaox.contentcenter.config;

import org.springframework.cloud.alibaba.sentinel.annotation.SentinelRestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * @Author WJH
 * @Description
 * @date 2020/11/27 10:58
 * @Email ibytecode2020@gmail.com
 */
@Configuration
public class HttpConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        //        template.setInterceptors(
//                Collections.singletonList(
//                        new BasicAuthorizationInterceptor()
//                )
//        );
        return new RestTemplate();
    }
}
