package cn.liyu.springbootredismq.service;

import cn.liyu.springbootredismq.pojo.User;

public interface ProduceService {

	public void produceMsg(User user);
	public void produceStr(String json);
	public void lpush(User user);
}
