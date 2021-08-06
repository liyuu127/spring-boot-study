package cn.liyu.mapper;

import cn.liyu.model.CrowdFunding;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrowdFundingMapper extends BaseMapper<CrowdFunding> {
    int updateBatch(List<CrowdFunding> list);

    int batchInsert(@Param("list") List<CrowdFunding> list);

    int insertOrUpdate(CrowdFunding record);

    int insertOrUpdateSelective(CrowdFunding record);
}