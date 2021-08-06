package cn.liyu.mapper;

import cn.liyu.model.Line;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LineMapper extends BaseMapper<Line> {
    int updateBatch(List<Line> list);

    int batchInsert(@Param("list") List<Line> list);

    int insertOrUpdate(Line record);

    int insertOrUpdateSelective(Line record);
}