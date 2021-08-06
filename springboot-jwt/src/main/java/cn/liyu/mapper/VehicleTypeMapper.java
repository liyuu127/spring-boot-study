package cn.liyu.mapper;

import cn.liyu.model.VehicleType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleTypeMapper extends BaseMapper<VehicleType> {
    int updateBatch(List<VehicleType> list);

    int batchInsert(@Param("list") List<VehicleType> list);

    int insertOrUpdate(VehicleType record);

    int insertOrUpdateSelective(VehicleType record);
}