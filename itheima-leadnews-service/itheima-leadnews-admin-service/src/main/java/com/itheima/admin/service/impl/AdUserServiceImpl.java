package com.itheima.admin.service.impl;

import com.itheima.admin.pojo.AdUser;
import com.itheima.admin.mapper.AdUserMapper;
import com.itheima.admin.service.AdUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.util.AppJwtUtil;
import com.itheima.common.vo.LoginResultVo;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @version 1.0
 * @description <p>管理员用户信息 业务实现</p>
 * @package com.itheima.admin.service.impl
 */
@Service
public class AdUserServiceImpl extends ServiceImpl<AdUserMapper, AdUser> implements AdUserService {

    /**
     * 首页登录
     * @param paramMap
     * @return
     */
    @Override
    public LoginResultVo login(Map<String, String> paramMap) {
        String username = paramMap.get("name");
        String password = paramMap.get("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new LeadNewsException("账号或密码不能为空");
        }
        AdUser loginUser = query().eq("name", username).one();
        if (loginUser == null) {
            throw new LeadNewsException("用户名或密码错误");
        }
        password += loginUser.getSalt();
        String ecryptedPwd = DigestUtils.md5DigestAsHex(password.getBytes());

        if (!ecryptedPwd.equals(loginUser.getPassword())) {
            throw new LeadNewsException("用户名或密码错误");

        }

        String token = AppJwtUtil.createToken(loginUser.getId());

        LoginResultVo vo = new LoginResultVo();

        loginUser.setPassword(null);
        loginUser.setPhone(null);
        loginUser.setSalt(null);
        vo.setUser(loginUser);
         vo.setToken(token);
        return vo;
    }
}

