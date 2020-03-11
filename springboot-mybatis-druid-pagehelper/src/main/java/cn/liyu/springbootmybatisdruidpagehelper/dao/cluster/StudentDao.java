package cn.liyu.springbootmybatisdruidpagehelper.dao.cluster;

import cn.liyu.springbootmybatisdruidpagehelper.dao.BaseDao;
import cn.liyu.springbootmybatisdruidpagehelper.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liyu
 * @date 2019/12/27 11:29
 * @description
 */
@Mapper
public interface StudentDao extends BaseDao<Student> {

}
