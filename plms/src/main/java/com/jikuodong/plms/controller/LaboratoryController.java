package com.jikuodong.plms.controller;


import com.jikuodong.plms.base.BaseController;
import com.jikuodong.plms.po.Laboratory;
import com.jikuodong.plms.service.LaboratoryService;
import com.jikuodong.plms.utils.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 站点实验室 前端控制器
 * </p>
 *
 * @author jikuodong
 * @since 2019-03-07
 */
@RestController
@RequestMapping("laboratory")
public class LaboratoryController extends BaseController {
    private LaboratoryService laboratoryService;

    @Autowired
    public LaboratoryController (LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    // 添加站点信息
    @RequestMapping("addLab")
    public void addLab() {
        logBefore(logger,"添加站点信息");
        PageData pd = this.getPageData();
        boolean res = laboratoryService.addLab("1", "测试", "1234567");
        System.out.println(res);
    }
}
