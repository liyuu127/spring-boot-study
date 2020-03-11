package cn.liyu.springbootmybatisdruidpagehelper.dao.master;

import cn.liyu.springbootmybatisdruidpagehelper.dao.BaseDao;
import cn.liyu.springbootmybatisdruidpagehelper.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liyu
 * @date 2019/12/27 11:27
 * @description  用户数据接口
 */
@Mapper
public interface UserDao extends BaseDao<User> {

}
