package cn.liyu.mapper;

import cn.liyu.model.OrderRefund;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderRefundMapper extends BaseMapper<OrderRefund> {
    int updateBatch(List<OrderRefund> list);

    int batchInsert(@Param("list") List<OrderRefund> list);

    int insertOrUpdate(OrderRefund record);

    int insertOrUpdateSelective(OrderRefund record);
}