package cn.liyu.mapper;

import cn.liyu.model.DispatcherReconciliation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatcherReconciliationMapper extends BaseMapper<DispatcherReconciliation> {
    int updateBatch(List<DispatcherReconciliation> list);

    int batchInsert(@Param("list") List<DispatcherReconciliation> list);

    int insertOrUpdate(DispatcherReconciliation record);

    int insertOrUpdateSelective(DispatcherReconciliation record);
}