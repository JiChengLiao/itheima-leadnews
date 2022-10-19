package com.itheima.admin.service;

import com.itheima.admin.pojo.AdUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.common.vo.LoginResultVo;
import com.itheima.common.vo.ResultVo;

import java.util.Map;

/**
 * @description <p>管理员用户信息 业务接口</p>
 *
 * @version 1.0
 * @package com.itheima.admin.service
 */
public interface AdUserService extends IService<AdUser> {

    LoginResultVo login(Map<String, String> paramMap);
}
