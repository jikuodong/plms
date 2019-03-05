package com.jikuodong.plms.controller.login;

import com.jikuodong.plms.base.BaseController;
import com.jikuodong.plms.interceptor.shiro.token.UsernamePasswordTokenCustom;
import com.jikuodong.plms.interceptor.shiro.token.manager.TokenManagerCustom;
import com.jikuodong.plms.po.UserCustom;
import com.jikuodong.plms.service.user.UserService;
import com.jikuodong.plms.utils.PageData;
import com.jikuodong.plms.utils.json.ReturnJsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 登录controller
 * @author JKD
 * @version 1.0.0
 * @ClassName LoginController.java
 * @createTime 2019年03月05日 10:00:00
 */
@RestController
public class LoginController extends BaseController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    // 登陆认证
    @RequestMapping("login")
    public Object login() throws Exception{
        PageData pd = getPageData();
        // 将获取到的字符串按规定进行分割
        String[] keys = parseKeyData(pd.getString("KeyData"));
        if (keys.length == 0) {
            throw new UnknownAccountException("用户不存在");
        }
        String code = keys[0];
        String password = keys[1];
        // 要支持多种方式登录，在此处查询数据库获取用户id
        UserCustom userCustom = userService.selectUserByUsernameOrPhoneOrOpenId(code);
        if (userCustom == null) {
            throw new UnknownAccountException("用户不存在");
        }
        // 密码加密
        String psd = new SimpleHash("SHA-1", userCustom.getUserId(), password).toString();
        // 登陆
        return loginAuth(userCustom, psd);
    }
    /* ---------------------------- 登录方法 ------------------------------ */

    /**
     * 登录操作
     * @param userCustom 用户实体类
     * @param psd 加密的密码
     * @return
     * @throws Exception
     */
    private Object loginAuth(UserCustom userCustom, String psd) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordTokenCustom(userCustom.getUserId(), psd);
        try {
           subject.login(token);
        } catch (IncorrectCredentialsException e) {
            // 密码错误，增加错误次数，然后抛出异常
            userService.updateUserFailureTimes(userCustom.getUserId(), userCustom.getFailureTimes()+1);
            throw e;
        }
        // 登录成功，更新登录信息，生成无状态token，返回
        userService.updateUserLoginInfo(userCustom.getUserId());
        String statelessToken = TokenManagerCustom.getInstance().createToken(userCustom);
        PageData pd = new PageData();
        pd.put("accessToken", statelessToken);
        return ReturnJsonUtil.returnSucc(pd);
    }


    /* --------------------------- 解析方法 -------------------------- */
    private static String[] parseKeyData(String keyData) {
        // 创建正则
        String reg = "^jkd0202(\\w+),jkd,(\\w+)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(keyData.trim());
        if (matcher.matches()) {
            String[] keys = new String[2];
            keys[0] = matcher.group(1);
            keys[1] =matcher.group(2);
            return keys;
        }
        return new String[0];
    }
}
