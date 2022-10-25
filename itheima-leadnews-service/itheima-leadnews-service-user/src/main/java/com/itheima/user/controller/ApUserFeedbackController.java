package com.itheima.user.controller;


import com.itheima.user.pojo.ApUserFeedback;
import com.itheima.user.service.ApUserFeedbackService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.core.controller.AbstractCoreController;

/**
 * @description <p>APP用户反馈信息</p>
 *
 * @version 1.0
 * @package com.itheima.user.controller
 */
@Api(value="ApUserFeedbackController",tags = "APP用户反馈信息")
@RestController
@RequestMapping("/apUserFeedback")
public class ApUserFeedbackController extends AbstractCoreController<ApUserFeedback> {

    private ApUserFeedbackService apUserFeedbackService;

    @Autowired
    public ApUserFeedbackController(ApUserFeedbackService apUserFeedbackService) {
        super(apUserFeedbackService);
        this.apUserFeedbackService=apUserFeedbackService;
    }

}

