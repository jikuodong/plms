package com.jikuodong.plms.mapper;

import com.jikuodong.plms.utils.PageData;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName PermissionMapperCustom.java
 * @createTime 2019年05月15日 08:48:00
 */
@Component
public interface PermissionMapperCustom {
    /**
     * 根据用户ID获取角色路由
     */
    List<PageData> findRoleRouterByUserId(String userId) throws Exception;
}
