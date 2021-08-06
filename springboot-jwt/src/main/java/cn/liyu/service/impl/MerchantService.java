package cn.liyu.service.impl;

import cn.liyu.mapper.MerchantMapper;
import cn.liyu.model.Merchant;
import cn.liyu.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyu
 * date 2020/8/6 10:54
 * description
 */
@Service
public class MerchantService implements IMerchantService {

    @Autowired
    MerchantMapper merchantMapper;


    @Override
    public boolean saveMerchant(Merchant merchant) {

        return merchantMapper.insert(merchant)>0;

    }

    @Override
    public List<Merchant> queryListByInfo(Merchant merchant) {
        return merchantMapper.selectByInfo(merchant);
    }

}
