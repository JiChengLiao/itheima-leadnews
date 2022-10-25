package com.itheima.user.service;

import com.itheima.common.vo.PageResultVo;
import com.itheima.user.dto.ApUserRealnamePageRequestDto;
import com.itheima.user.pojo.ApUserRealname;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @description <p>APP实名认证信息 业务接口</p>
 *
 * @version 1.0
 * @package com.itheima.user.service
 */
public interface ApUserRealnameService extends IService<ApUserRealname> {

    PageResultVo findpage(ApUserRealnamePageRequestDto dto);

    void authpass(Map<String, Object> paramMap);

    void authFail(Map<String, Object> paramMap);
}
