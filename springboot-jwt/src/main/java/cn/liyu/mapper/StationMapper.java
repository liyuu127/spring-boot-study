package cn.liyu.mapper;

import cn.liyu.model.Station;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StationMapper extends BaseMapper<Station> {
    int updateBatch(List<Station> list);

    int batchInsert(@Param("list") List<Station> list);

    int insertOrUpdate(Station record);

    int insertOrUpdateSelective(Station record);
}