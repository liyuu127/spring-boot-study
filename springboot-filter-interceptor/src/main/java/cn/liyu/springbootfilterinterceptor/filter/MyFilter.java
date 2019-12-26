package cn.liyu.springbootfilterinterceptor.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author liyu
 * @date 2019/12/25 14:44
 * @description 新建过滤器
 * 自定义的 Filter 需要实现javax.Servlet.Filter接口，并重写接口中定义的3个方法。
 */
@Component
@Slf4j
//@WebFilter(filterName = "MyFilter", urlPatterns = "/api/*") //注解形式注册过滤器
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器：{}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //对请求进行处理
        log.info("过滤器对请求开始预处理");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        System.out.println("请求的接口为：requestURI = " + requestURI);
        long startTime = System.currentTimeMillis();
        //通过doFilter方法实现过滤功能
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        System.out.println("请求处理完毕，花费时间：" + (endTime - startTime));

    }

    @Override
    public void destroy() {
        log.info("销毁过滤器");
    }
}
