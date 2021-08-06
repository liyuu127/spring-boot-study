package cn.liyu.mapper;

import cn.liyu.model.ScanRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScanRecordMapper extends BaseMapper<ScanRecord> {
    int updateBatch(List<ScanRecord> list);

    int batchInsert(@Param("list") List<ScanRecord> list);

    int insertOrUpdate(ScanRecord record);

    int insertOrUpdateSelective(ScanRecord record);
}