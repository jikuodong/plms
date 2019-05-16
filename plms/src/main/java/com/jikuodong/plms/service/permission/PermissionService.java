package com.jikuodong.plms.service.permission;

import com.jikuodong.plms.utils.PageData;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName PermissionService.java
 * @createTime 2019年05月14日 16:59:00
 */
public interface PermissionService {
    /**
     * 获取角色路由信息
     */
    PageData findUserRouter(String userId) throws Exception;
}
