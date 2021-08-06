package cn.liyu.mapper;

import cn.liyu.model.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends BaseMapper<Order> {
    int updateBatch(List<Order> list);

    int batchInsert(@Param("list") List<Order> list);

    int insertOrUpdate(Order record);

    int insertOrUpdateSelective(Order record);
}