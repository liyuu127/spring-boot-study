package cn.liyu.mapper;

import cn.liyu.model.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
    int updateBatch(List<Message> list);

    int batchInsert(@Param("list") List<Message> list);

    int insertOrUpdate(Message record);

    int insertOrUpdateSelective(Message record);
}