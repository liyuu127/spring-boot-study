package cn.liyu.mapper;

import cn.liyu.model.LineStation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LineStationMapper extends BaseMapper<LineStation> {
    int updateBatch(List<LineStation> list);

    int batchInsert(@Param("list") List<LineStation> list);

    int insertOrUpdate(LineStation record);

    int insertOrUpdateSelective(LineStation record);
}