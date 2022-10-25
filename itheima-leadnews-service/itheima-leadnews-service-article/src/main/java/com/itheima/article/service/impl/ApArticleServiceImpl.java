package com.itheima.article.service.impl;

import com.itheima.article.pojo.ApArticle;
import com.itheima.article.mapper.ApArticleMapper;
import com.itheima.article.service.ApArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @description <p>已发布的文章信息 业务实现</p>
 *
 * @version 1.0
 * @package com.itheima.article.service.impl
 */
@Service
public class ApArticleServiceImpl extends ServiceImpl<ApArticleMapper, ApArticle> implements ApArticleService {

}
