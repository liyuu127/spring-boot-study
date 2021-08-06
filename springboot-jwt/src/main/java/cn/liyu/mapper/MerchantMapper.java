package cn.liyu.mapper;

import cn.liyu.model.Merchant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MerchantMapper extends BaseMapper<Merchant> {
    int updateBatch(List<Merchant> list);

    int batchInsert(@Param("list") List<Merchant> list);

    int insertOrUpdate(Merchant record);

    int insertOrUpdateSelective(Merchant record);

    List<Merchant> selectByInfo(Merchant merchant);
}