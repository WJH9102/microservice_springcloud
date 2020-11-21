package cn.junhaox.contentcenter.controller;

import cn.junhaox.contentcenter.dao.content.ShareMapper;
import cn.junhaox.contentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author WJH
 * @Description
 * @date 2020/11/21 16:24
 * @Email ibytecode2020@gmail.com
 */
@RestController
public class TestController {

    @Autowired
    ShareMapper shareMapper;

    @GetMapping("/test")
    public List<Share> test() {
        Share share = new Share();
        share.setAuditStatus("xxx");
        share.setAuthor("www");
        share.setBuyCount(12);
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        shareMapper.insertSelective(share);
        List<Share> shares = shareMapper.selectAll();
        return shares;
    }

}
