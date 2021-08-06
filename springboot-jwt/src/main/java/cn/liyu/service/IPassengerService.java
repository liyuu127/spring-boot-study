package cn.liyu.service;

import cn.liyu.model.Passenger;

import java.util.List;

/**
 * @author liyu
 * date 2020/8/6 10:53
 * description
 */
public interface IPassengerService {

    /**
     * 保存乘客
     * @param passenger
     * @return
     */
    public boolean savePassenger(Passenger passenger);

    /**
     * 查询乘客集合
     * @param passenger
     * @return
     */
    public List<Passenger> queryListByPassenger(Passenger passenger);
}
