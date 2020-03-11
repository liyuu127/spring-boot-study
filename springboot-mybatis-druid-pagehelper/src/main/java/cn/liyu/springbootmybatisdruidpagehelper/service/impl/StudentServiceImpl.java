package cn.liyu.springbootmybatisdruidpagehelper.service.impl;

import cn.liyu.springbootmybatisdruidpagehelper.dao.BaseDao;
import cn.liyu.springbootmybatisdruidpagehelper.dao.cluster.StudentDao;
import cn.liyu.springbootmybatisdruidpagehelper.pojo.Student;
import cn.liyu.springbootmybatisdruidpagehelper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyu
 * @date 2019/12/27 13:58
 * @description
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    protected BaseDao<Student> getMapper() {
        return this.studentDao;
    }

}
