package cn.junhaox.contentcenter.service;

import cn.junhaox.contentcenter.dao.content.ShareMapper;
import cn.junhaox.contentcenter.domain.dto.content.ShareDTO;
import cn.junhaox.contentcenter.domain.dto.user.UserDTO;
import cn.junhaox.contentcenter.domain.entity.content.Share;
import cn.junhaox.contentcenter.feignclient.UserCenterFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @Author WJH
 * @Description
 * @date 2020/11/27 9:19
 * @Email ibytecode2020@gmail.com
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {
    private final ShareMapper shareMapper;
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;
    private final UserCenterFeignClient userCenterFeignClient;

    public ShareDTO findById(Integer id) {
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人id
        Integer userId = share.getUserId();

        // 1. 代码不可读
        // 2. 复杂的url难以维护：https://user-center/s?ie={ie}&f={f}&rsv_bp=1&rsv_idx=1&tn=baidu&wd=a&rsv_pq=c86459bd002cfbaa&rsv_t=edb19hb%2BvO%2BTySu8dtmbl%2F9dCK%2FIgdyUX%2BxuFYuE0G08aHH5FkeP3n3BXxw&rqlang=cn&rsv_enter=1&rsv_sug3=1&rsv_sug2=0&inputT=611&rsv_sug4=611
        // 3. 难以相应需求的变化，变化很没有幸福感
        // 4. 编程体验不统一
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
//        List<String> targetUrls = instances.stream()
//                .map(instance -> instance.getUri().toString() + "/users/{id}")
//                .collect(Collectors.toList());
//        int randomI = ThreadLocalRandom.current().nextInt(targetUrls.size());
//        log.info("请求地址{}", targetUrls.get(randomI));
//        RestTemplate restTemplate = new RestTemplate();
        UserDTO userDTO = userCenterFeignClient.findById(userId);
        ShareDTO shareDTO = new ShareDTO();
        // 消息的装配
        BeanUtils.copyProperties(share, shareDTO);
        assert userDTO != null;
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }
}
