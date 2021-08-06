package cn.liyu.mapper;

import cn.liyu.model.SysAuthOrdinal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthOrdinalMapper extends BaseMapper<SysAuthOrdinal> {
    int updateBatch(List<SysAuthOrdinal> list);

    int batchInsert(@Param("list") List<SysAuthOrdinal> list);

    int insertOrUpdate(SysAuthOrdinal record);

    int insertOrUpdateSelective(SysAuthOrdinal record);
}