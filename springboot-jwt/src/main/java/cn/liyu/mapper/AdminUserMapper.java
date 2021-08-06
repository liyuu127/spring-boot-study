package cn.liyu.mapper;

import cn.liyu.model.AdminUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
    int updateBatch(List<AdminUser> list);

    int batchInsert(@Param("list") List<AdminUser> list);

    int insertOrUpdate(AdminUser record);

    int insertOrUpdateSelective(AdminUser record);
}