package com.itheima.article.service.impl;

import com.itheima.article.pojo.ApAuthor;
import com.itheima.article.mapper.ApAuthorMapper;
import com.itheima.article.service.ApAuthorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @description <p>APP文章作者信息 业务实现</p>
 *
 * @version 1.0
 * @package com.itheima.article.service.impl
 */
@Service
public class ApAuthorServiceImpl extends ServiceImpl<ApAuthorMapper, ApAuthor> implements ApAuthorService {

    @Override
    public ApAuthor getByApUserIdAndWmUserId(Long apUserId, Long wmUserId) {

        return query().eq("user_id",apUserId).eq("wm_user_id", wmUserId).one();
    }
}
