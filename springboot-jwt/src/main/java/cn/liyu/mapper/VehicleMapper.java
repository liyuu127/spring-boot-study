package cn.liyu.mapper;

import cn.liyu.model.Vehicle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleMapper extends BaseMapper<Vehicle> {
    int updateBatch(List<Vehicle> list);

    int batchInsert(@Param("list") List<Vehicle> list);

    int insertOrUpdate(Vehicle record);

    int insertOrUpdateSelective(Vehicle record);
}