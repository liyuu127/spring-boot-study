//package cn.liyu.springbootfilterinterceptor.filter;
//
//
//import com.github.isrsal.logging.RequestWrapper;
//import com.github.isrsal.logging.ResponseWrapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * @author liyu
// * @date 2019/12/25 14:44
// * @description 新建过滤器
// * 自定义的 Filter 需要实现javax.Servlet.Filter接口，并重写接口中定义的3个方法。
// */
//@Component
//@Slf4j
////@WebFilter(filterName = "MyFilter", urlPatterns = "/api/*") //注解形式注册过滤器
//public class MyFilter extends OncePerRequestFilter {
//    @Autowired
//    private PrintLogSupport printLogSupport;
//
//
//
//    @Override
//    public void destroy() {
//        log.info("销毁过滤器");
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        //对请求进行处理
//        log.info("过滤器对请求开始预处理");
//        ResponseWrapper  responseWrapper = new ResponseWrapper(Thread.currentThread().getId(), (HttpServletResponse) response);
//        HttpServletRequest httpServletRequest = (HttpServletRequest) response;
//        RequestWrapper requestWrapper = new RequestWrapper(Thread.currentThread().getId(), httpServletRequest);
//        String requestURI = request.getRequestURI();
//        System.out.println("请求的接口为：requestURI = " + requestURI);
//        long startTime = System.currentTimeMillis();
//        //通过doFilter方法实现过滤功能
//        filterChain.doFilter(requestWrapper, responseWrapper);
//        long endTime = System.currentTimeMillis();
//        System.out.println("请求处理完毕，花费时间：" + (endTime - startTime));
//
//        printLogSupport.printLog(request.getParameterMap(),responseWrapper);
//    }
//}
