package com.jikuodong.plms.service.permission.impl;

import com.jikuodong.plms.mapper.PermissionMapperCustom;
import com.jikuodong.plms.service.permission.PermissionService;
import com.jikuodong.plms.utils.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName PermissionServiceImpl.java
 * @createTime 2019年05月14日 16:59:00
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    private PermissionMapperCustom permissionMapperCustom;

    @Autowired
    public PermissionServiceImpl(PermissionMapperCustom permissionMapperCustom) {
        this.permissionMapperCustom = permissionMapperCustom;
    }
    /**
     * 获取角色路由信息
     *
     * @param userId
     */
    @Override
    public PageData findUserRouter(String userId) throws Exception {
        // 获取角色的菜单路由信息
        List<PageData> routerList = permissionMapperCustom.findRoleRouterByUserId(userId);
        return assembleRouter(routerList);
    }

    /**
     * 根据路由信息，拼装路由数据格式
     */
    private PageData assembleRouter(List<PageData> list) {
        // 1.先拼装为单个路由
        List<PageData> routersList = new ArrayList<>();
        list.forEach(e -> {
            PageData pd = new PageData();
            PageData meta = new PageData();
            pd.put("menuId", e.getString("MENU_ID"));
            pd.put("parentId", e.getString("PARENT_ID"));
            pd.put("path", e.getString("MENU_URL"));
            pd.put("component", e.getString("COMPONENT_PATH"));
            if (!(e.getString("REDIRECT").equals(""))) {
                pd.put("redirect", e.getString("REDIRECT"));
            }
            if (!(e.getString("ROUTER_NAME").equals(""))) {
                pd.put("name", e.getString("ROUTER_NAME"));
            }
            meta.put("title", e.getString("MENU_NAME"));
            meta.put("icon", e.getString("MENU_ICON"));
            pd.put("meta", meta);
            routersList.add(pd);
        });
        // 调用递归拼接子路由
        // 创建一个根节点router，menuId为0
        PageData root = new PageData();
        root.put("menuId", 0);
        recursChildrenRouter(root, routersList);
        root.remove("menuId");
        return root;
    }
    // 递归拼接子路由，传递的是引用
    private void recursChildrenRouter(PageData parent, List<PageData> list) {
        List<PageData> childrenList = new ArrayList<>();
        System.out.println(list.stream().filter(e -> e.getString("parentId").equals(parent.getString("menuId"))).count());
        list.stream().filter(e -> e.getString("parentId").equals(parent.getString("menuId"))).forEach(e -> {
            recursChildrenRouter(e, list);
            e.remove("parentId");
            e.remove("menuId");
            childrenList.add(e);
        });
        if (!childrenList.isEmpty()) {
            parent.put("children", childrenList);
        }
    }
}
