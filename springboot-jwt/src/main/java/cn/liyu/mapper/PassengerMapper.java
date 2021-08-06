package cn.liyu.mapper;
import java.util.Date;

import cn.liyu.model.Passenger;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PassengerMapper extends BaseMapper<Passenger> {
    int updateBatch(List<Passenger> list);

    int batchInsert(@Param("list") List<Passenger> list);

    int insertOrUpdate(Passenger record);

    int insertOrUpdateSelective(Passenger record);

    List<Passenger> queryByInfo(Passenger passenger);




}