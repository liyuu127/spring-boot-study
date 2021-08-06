package cn.liyu.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liyu
 * date 2020/8/6 10:45
 * description
 */
public interface IUserService {

    /**
     * 登录接口
     * @param account 全数字是判定为手机号，否则为账号名
     * @param password 长度>=8是为密码登陆，否则为验证码
     * @return
     */
    public JSONObject Login(String account, String password) throws Exception;

}
