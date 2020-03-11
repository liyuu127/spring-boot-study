package cn.liyu.springbootmybatisdruidpagehelper.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyu
 * @date 2019/12/27 9:52
 * @description druid监控界面设置
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        //注册服务
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        //添加白名单（为空表示所有的都能访问，多个IP的时候用逗号隔开）
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //添加IP黑名单，（deny的优先级高于allow）
        servletRegistrationBean.addInitParameter("deny", "127.0.0.2");

        //设置登录用的用户名和密码
        //启动程序，在浏览器输入:http://127.0.0.1:8084/druid/index.html ，然后输入设置的用户名和密码，访问Web界面
        servletRegistrationBean.addInitParameter("loginUsername", "root");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");

        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");

        //添加不需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        System.out.println("druid 初始化成功！！！");

        return filterRegistrationBean;
    }

}
