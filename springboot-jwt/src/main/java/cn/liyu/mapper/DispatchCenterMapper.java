package cn.liyu.mapper;

import cn.liyu.model.DispatchCenter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatchCenterMapper extends BaseMapper<DispatchCenter> {
    int updateBatch(List<DispatchCenter> list);

    int batchInsert(@Param("list") List<DispatchCenter> list);

    int insertOrUpdate(DispatchCenter record);

    int insertOrUpdateSelective(DispatchCenter record);
}