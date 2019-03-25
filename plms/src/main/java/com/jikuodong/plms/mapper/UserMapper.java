package com.jikuodong.plms.mapper;

import java.util.List;

import com.jikuodong.plms.po.User;
import com.jikuodong.plms.po.UserCustom;
import com.jikuodong.plms.po.UserExample;
import com.jikuodong.plms.utils.PageData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    // 根据用户名或手机号码查询用户信息
    UserCustom selectUserByUsernameOrPhoneOrOpenId(String code) throws Exception;
    int updateByPrimaryKeySelective(User record);
    // 获取用户基本信息
    UserCustom findUserBaseInfoByUserId(String userId) throws Exception;
    // 获取用户列表
    List<User> getUserList (PageData pd) throws Exception;
}
