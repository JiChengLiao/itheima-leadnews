package com.itheima.wemedia.service;

import com.itheima.common.vo.LoginResultVo;
import com.itheima.wemedia.pojo.WmUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @description <p>自媒体用户信息 业务接口</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.service
 */
public interface WmUserService extends IService<WmUser> {

    WmUser getByApUserId(Long apUserId);

    LoginResultVo login(Map<String, String> paramMap);
}
