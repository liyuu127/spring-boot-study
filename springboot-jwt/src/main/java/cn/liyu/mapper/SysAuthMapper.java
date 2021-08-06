package cn.liyu.mapper;

import cn.liyu.model.SysAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthMapper extends BaseMapper<SysAuth> {
    int updateBatch(List<SysAuth> list);

    int batchInsert(@Param("list") List<SysAuth> list);

    int insertOrUpdate(SysAuth record);

    int insertOrUpdateSelective(SysAuth record);
}