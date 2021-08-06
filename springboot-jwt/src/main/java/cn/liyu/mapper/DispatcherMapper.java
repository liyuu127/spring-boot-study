package cn.liyu.mapper;

import cn.liyu.model.Dispatcher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatcherMapper extends BaseMapper<Dispatcher> {
    int updateBatch(List<Dispatcher> list);

    int batchInsert(@Param("list") List<Dispatcher> list);

    int insertOrUpdate(Dispatcher record);

    int insertOrUpdateSelective(Dispatcher record);
}