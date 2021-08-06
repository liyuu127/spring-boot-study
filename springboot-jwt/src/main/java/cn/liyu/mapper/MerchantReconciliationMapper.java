package cn.liyu.mapper;

import cn.liyu.model.MerchantReconciliation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantReconciliationMapper extends BaseMapper<MerchantReconciliation> {
    int updateBatch(List<MerchantReconciliation> list);

    int batchInsert(@Param("list") List<MerchantReconciliation> list);

    int insertOrUpdate(MerchantReconciliation record);

    int insertOrUpdateSelective(MerchantReconciliation record);
}