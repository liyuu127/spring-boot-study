package cn.liyu.mapper;

import cn.liyu.model.WorkOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkOrderMapper extends BaseMapper<WorkOrder> {
    int updateBatch(List<WorkOrder> list);

    int batchInsert(@Param("list") List<WorkOrder> list);

    int insertOrUpdate(WorkOrder record);

    int insertOrUpdateSelective(WorkOrder record);
}