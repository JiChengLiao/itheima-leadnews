package com.itheima.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.article.feign.ApAuthorFeign;
import com.itheima.article.pojo.ApAuthor;
import com.itheima.common.constants.BusinessConstants;
import com.itheima.common.exception.LeadNewsException;
import com.itheima.common.vo.PageResultVo;
import com.itheima.common.vo.ResultVo;
import com.itheima.user.dto.ApUserRealnamePageRequestDto;
import com.itheima.user.mapper.ApUserMapper;
import com.itheima.user.pojo.ApUser;
import com.itheima.user.pojo.ApUserRealname;
import com.itheima.user.mapper.ApUserRealnameMapper;
import com.itheima.user.service.ApUserRealnameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.wemedia.feign.WmUserFeign;
import com.itheima.wemedia.pojo.WmUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @version 1.0
 * @description <p>APP实名认证信息 业务实现</p>
 * @package com.itheima.user.service.impl
 */
@Slf4j
@Service
public class ApUserRealnameServiceImpl extends ServiceImpl<ApUserRealnameMapper, ApUserRealname> implements ApUserRealnameService {

    @Resource
    private ApUserMapper apUserMapper;

    @Autowired
    private WmUserFeign wmUserFeign;

    @Autowired
    private ApAuthorFeign apAuthorFeign;

    @Override
    public PageResultVo findpage(ApUserRealnamePageRequestDto dto) {
        Page<ApUserRealname> pageifo = new Page<>();
        LambdaQueryWrapper<ApUserRealname> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(null != dto.getStatus(), ApUserRealname::getStatus, dto.getStatus());
        page(pageifo, wrapper);
        return PageResultVo.pageResult(dto.getPage(), dto.getSize(), pageifo.getTotal(), pageifo.getRecords());

    }

    @Override
    public void authpass(Map<String, Object> paramMap) {
        Integer id = (Integer) paramMap.get("id");
        ApUserRealname apUserRealname = getById(id);

        if (apUserRealname == null || apUserRealname.getStatus() != 1) {
            throw new LeadNewsException("数据不存在，状态不存在");
        }

        ApUserRealname updatePojo = new ApUserRealname();
        updatePojo.setId(id.longValue());
        updatePojo.setStatus(BusinessConstants.ApUserRealnameConstants.AUTH_PASS);
        updatePojo.setCreatedTime(LocalDateTime.now());
        updateById(updatePojo);
        //用户信息
        Long apUserId = apUserRealname.getUserId();
        ApUser updateApUser = new ApUser();
        updateApUser.setId(apUserId);
        updateApUser.setFlag(BusinessConstants.ApUserConstants.FLAG_WEMEDIA);
        updateApUser.setIsIdentityAuthentication(BusinessConstants.ApUserConstants.AUTHENTICATED);
        apUserMapper.updateById(updateApUser);

        ResultVo<WmUser> getByApUserIdResult = wmUserFeign.getByApUserId(apUserId);
        System.out.println(apUserId);

        if (!getByApUserIdResult.isSuccess()) {
            log.error("用户实名验证：：远程调用失败：{},{}", apUserId, getByApUserIdResult.getErrorMessage());
            throw new LeadNewsException("查询自媒体用户信息失败");
        }

        ApUser apUserInfo = apUserMapper.selectById(apUserId);
        WmUser wmUser = getByApUserIdResult.getData();

        if (wmUser == null) {

            wmUser = addWmUser(apUserInfo);

        }

        //作者表操作
        //1远程调用
        ResultVo<ApAuthor> getApUserResult = apAuthorFeign.getByApUserIdWmUserId(apUserId, wmUser.getId());
//1. 通过apUserId与自媒体账号id查询作者是否存在
        ResultVo<ApAuthor> getResult = apAuthorFeign.getByApUserIdWmUserId(apUserId, wmUser.getId());
        //2. 解析查询结果
        if(!getResult.isSuccess()) {
            //3. 远程调用失败，报错
            log.error("远程调用文章微服查询作者失败了!:" + getResult.getErrorMessage());
            throw new LeadNewsException("实名认证失败!:" + getResult.getErrorMessage());
        }
        //2不存在就添加
        ApAuthor autho = getApUserResult.getData();
        if(autho==null){

            addAuthor(apUserInfo,wmUser.getId());
        }


    }

    /**
     * 审核驳回
     * @param paramMap
     */
    @Override
    public void authFail(Map<String, Object> paramMap) {
       Integer id = (Integer) paramMap.get("id");
       String msg = (String) paramMap.get("msg");
        ApUserRealname apUserRealName=new  ApUserRealname();
       if (id!=null){


       apUserRealName.setId(id.longValue());
       apUserRealName.setStatus(BusinessConstants.ApUserRealnameConstants.AUTH_REJECT);
       apUserRealName.setUpdatedTime(LocalDateTime.now());
       apUserRealName.setReason(msg);
       }
         updateById(apUserRealName);

    }

    /**
     * 远程调用作者
     * @param apUserInfo
     * @param wmUserId
     */
    private void addAuthor(ApUser apUserInfo, Long wmUserId) {
        ApAuthor apAuthor = new ApAuthor();
        apAuthor.setWmUserId(wmUserId);
        apAuthor.setName(apUserInfo.getName());
        apAuthor.setUserId(apUserInfo.getId());
        apAuthor.setType(BusinessConstants.ApAuthorConstants.A_MEDIA_USER);
        apAuthor.setCreatedTime(LocalDateTime.now());

        ResultVo add = apAuthorFeign.add(apAuthor);

        if (!add.isSuccess()){
            log.error("用户实名验证：：远程调用失败添加作者：{},{},{}", apUserInfo.getId(), wmUserId, add.getErrorMessage());
            throw new LeadNewsException("查询自媒体用户信息失败");
        }


    }

    private WmUser addWmUser( ApUser apUserInfo) {
        WmUser wmUser = new WmUser();
        BeanUtils.copyProperties(apUserInfo,wmUser);

        wmUser.setId(null);
        wmUser.setNickname(apUserInfo.getName());
        wmUser.setType(BusinessConstants.WmUserConstants.TYPE_PERSONAL);
        wmUser.setStatus(BusinessConstants.WmUserConstants.STATUS_OK);
        wmUser.setScore(0);
        wmUser.setApUserId(apUserInfo.getId());
        ResultVo<WmUser>add = wmUserFeign.add(wmUser);
        if(!add.isSuccess()){

            log.error("用户实名验证：：远程调用自媒体失败：{},{}", apUserInfo.getId(), add.getErrorMessage());
            throw new LeadNewsException("添加失败");
        }
        return add.getData();

    }


}
