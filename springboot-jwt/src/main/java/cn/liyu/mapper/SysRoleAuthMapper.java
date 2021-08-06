package cn.liyu.mapper;

import cn.liyu.model.SysRoleAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleAuthMapper extends BaseMapper<SysRoleAuth> {
    int updateBatch(List<SysRoleAuth> list);

    int batchInsert(@Param("list") List<SysRoleAuth> list);

    int insertOrUpdate(SysRoleAuth record);

    int insertOrUpdateSelective(SysRoleAuth record);
}