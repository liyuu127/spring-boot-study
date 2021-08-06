package cn.liyu.mapper;

import cn.liyu.model.Driver;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverMapper extends BaseMapper<Driver> {
    int updateBatch(List<Driver> list);

    int batchInsert(@Param("list") List<Driver> list);

    int insertOrUpdate(Driver record);

    int insertOrUpdateSelective(Driver record);
}