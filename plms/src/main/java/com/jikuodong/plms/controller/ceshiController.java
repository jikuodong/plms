package com.jikuodong.plms.controller;

import com.jikuodong.plms.base.BaseController;
import com.jikuodong.plms.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ji kuodong
 * @version 1.0.0
 * @ClassName ceshiController.java
 * @Description TODO
 * @createTime 2018年10月15日 15:24:00
 */
@Controller
@RequestMapping("ceshi")
public class ceshiController extends BaseController {
    @RequestMapping("getName")
    public void getName() {
        logBefore(logger,"测试");
        PageData pd = this.getPageData();
        System.out.println(pd);
    }
}
