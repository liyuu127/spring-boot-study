package cn.liyu.service.impl;

import cn.liyu.config.JwtConfig;
import cn.liyu.constants.RedisConstant;
import cn.liyu.constants.UserConstant;
import cn.liyu.mapper.MerchantMapper;
import cn.liyu.mapper.PassengerMapper;
import cn.liyu.model.Merchant;
import cn.liyu.model.UserInfo;
import cn.liyu.service.IMerchantService;
import cn.liyu.service.IPassengerService;
import cn.liyu.service.IUserService;
import cn.liyu.utils.JwtUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author liyu
 * date 2020/8/6 10:41
 * description
 */
@Service
public class UserService implements IUserService {

    @Autowired
    PassengerMapper passengerMapper;

    @Autowired
    MerchantMapper merchantMapper;

    @Autowired
    IPassengerService passengerService;

    @Autowired
    IMerchantService merchantService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    JwtConfig jwtConfig;

    @Override
    public JSONObject Login(String account, String password) throws Exception {

        JSONObject object = new JSONObject();
        String telRegex = "^((13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$";
        boolean isTel = account.matches(telRegex);
        boolean isPassword = password.length() >= 8;
        //商家支持用户名，手机号密码登陆
        if (isPassword) {

            Merchant merchantInfo = new Merchant();
            merchantInfo.setPassword(password);
            if (isTel) {
                merchantInfo.setContactPhone(account);
            } else {
                merchantInfo.setUsername(account);
            }
            List<Merchant> merchants = merchantService.queryListByInfo(merchantInfo);
            if (!merchants.isEmpty()) {
                Merchant merchant = merchants.get(0);
                String token = JwtUtils.generateToken(new UserInfo(merchant.getId(), UserConstant.USER_TYPE_MERCHANT, merchant.getUsername()),
                        jwtConfig.getPrivateKey(), jwtConfig.getExpire());
                object.put("token", token);
                object.put("userInfo", JSON.toJSON(merchant));
                return object;
            }else {
                throw new Exception("用户名或密码不正确");
            }

        } else {
            //车长，商家支持手机、验证码登录
            if(isTel){
                //从redis拿到验证码
                String code = redisTemplate.opsForValue().get(RedisConstant.LOGIN_VERIFICATION_CODE_PREFIX + account);
                if(code==null){
                    throw new Exception("验证码已过期");
                }
                if(!Objects.equals(code, password)){
                    throw new Exception("验证码不正确");
                }

                //先查询商家用户
                List<Merchant> merchants = merchantService.queryListByInfo(new Merchant().setContactPhone(account));


            }else {
                throw new Exception("手机号不正确");
            }
        }

        return null;
    }
}
