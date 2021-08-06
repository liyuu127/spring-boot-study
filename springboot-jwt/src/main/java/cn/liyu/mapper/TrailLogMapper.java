package cn.liyu.mapper;

import cn.liyu.model.TrailLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrailLogMapper extends BaseMapper<TrailLog> {
    int updateBatch(List<TrailLog> list);

    int batchInsert(@Param("list") List<TrailLog> list);

    int insertOrUpdate(TrailLog record);

    int insertOrUpdateSelective(TrailLog record);
}