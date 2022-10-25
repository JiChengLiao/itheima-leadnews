package com.itheima.wemedia.service.impl;

import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.util.AppJwtUtil;
import com.itheima.common.vo.LoginResultVo;
import com.itheima.wemedia.pojo.WmUser;
import com.itheima.wemedia.mapper.WmUserMapper;
import com.itheima.wemedia.service.WmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Map;

/**
 * @description <p>自媒体用户信息 业务实现</p>
 *
 * @version 1.0
 * @package com.itheima.wemedia.service.impl
 */
@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser> implements WmUserService {

    @Override
    public WmUser getByApUserId(Long apUserId) {
        return query().eq("ap_user_id", apUserId).one();

    }

    @Override
    public LoginResultVo login(Map<String, String> paramMap) {
       //1验证前端传过来的用户名与密码跟数据库是否一直

        //1.1取出账号密码g判断是否为空
        String username = paramMap.get("name");
        String password = paramMap.get("password");
        if (username.isEmpty()||password.isEmpty()){
            throw new LeadNewsException("请输入账号密码");
        }
        //1.2通过登录用户名来查询数据库用户表
        WmUser wmUser = query().eq("name", username).one();
        //1.4对查询的用户名进行非空判断
        if (null==wmUser){
            throw new LeadNewsException("用户名或密码错误");
        }
        //1.5把前端的密码加盐后加密

        String encryptedPwd = DigestUtils.md5DigestAsHex((password + wmUser.getSalt()).getBytes());
        //1.5把前端加盐后的字符串与数据库的密码进行比较

        if (!encryptedPwd.equals(wmUser.getPassword())){
            //1.6不同则报错
            throw new LeadNewsException("对不起，您输入的账号密码有误");
        }
        //2相同，校验通过，构建对象放回
        LoginResultVo vo =new LoginResultVo();
        //2.1构建vo对象，token，user对象
        String token = AppJwtUtil.createToken(wmUser.getId());
        //通过用户的id生成token
        vo.setToken(token);
        //2.2设置token
        wmUser.setSalt(null);
        wmUser.setPassword(null);
        wmUser.setPhone(null);
        //2.3设置用户信息脱敏操作
        vo.setUser(wmUser);
       //2.4设置用户信息
        //3返回
        return vo;
    }
}
