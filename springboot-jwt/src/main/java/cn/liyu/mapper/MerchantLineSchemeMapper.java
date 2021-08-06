package cn.liyu.mapper;

import cn.liyu.model.MerchantLineScheme;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantLineSchemeMapper extends BaseMapper<MerchantLineScheme> {
    int updateBatch(List<MerchantLineScheme> list);

    int batchInsert(@Param("list") List<MerchantLineScheme> list);

    int insertOrUpdate(MerchantLineScheme record);

    int insertOrUpdateSelective(MerchantLineScheme record);
}