package cn.liyu.service.impl;

import cn.liyu.mapper.PassengerMapper;
import cn.liyu.model.Passenger;
import cn.liyu.service.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyu
 * date 2020/8/6 11:08
 * description
 */
@Service
public class PassengerService implements IPassengerService {

    @Autowired
    PassengerMapper passengerMapper;

    @Override
    public boolean savePassenger(Passenger passenger) {
        return passengerMapper.insert(passenger) > 0;
    }

    @Override
    public List<Passenger> queryListByPassenger(Passenger passenger) {
        return passengerMapper.queryByInfo(passenger);
    }
}
