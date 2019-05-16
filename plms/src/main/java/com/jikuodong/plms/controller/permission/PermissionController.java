package com.jikuodong.plms.controller.permission;

import com.jikuodong.plms.base.BaseController;
import com.jikuodong.plms.po.UserCustom;
import com.jikuodong.plms.service.permission.PermissionService;
import com.jikuodong.plms.utils.PageData;
import com.jikuodong.plms.utils.json.ReturnJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * describe 菜单权限
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName PermissionController.java
 * @createTime 2019年05月14日 16:53:00
 */
@RestController
@RequestMapping("permission")
public class PermissionController extends BaseController {
    private PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * 获取角色路由信息
     */
    @RequestMapping("getAsyncRouter")
    public Object getAsyncRouter() throws Exception{
        logBefore(logger, "获取角色路由信息");
        UserCustom userCustom = (UserCustom) getCurrentUser();
        PageData userRouter = permissionService.findUserRouter(userCustom.getUserId());
        return ReturnJsonUtil.returnSucc(userRouter);
    }

}
