package cn.liyu.service;

import cn.liyu.model.Merchant;

import java.util.List;

/**
 * @author liyu
 * date 2020/8/6 10:54
 * description
 */
public interface IMerchantService {

    /**
     * 保存商家
     *
     * @param merchant
     * @return
     */
    public boolean saveMerchant(Merchant merchant);

    /**
     * 查询商家
     *
     * @param merchant
     * @return
     */
    public List<Merchant> queryListByInfo(Merchant merchant);

}
