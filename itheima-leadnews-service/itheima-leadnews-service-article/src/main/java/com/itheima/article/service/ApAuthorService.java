package com.itheima.article.service;

import com.itheima.article.pojo.ApAuthor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @description <p>APP文章作者信息 业务接口</p>
 *
 * @version 1.0
 * @package com.itheima.article.service
 */
public interface ApAuthorService extends IService<ApAuthor> {

    ApAuthor getByApUserIdAndWmUserId(Long apUserId, Long wmUserId);
}
