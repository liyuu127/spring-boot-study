//package cn.liyu.springbootfilterinterceptor.filter;
//
//import com.alibaba.fastjson.JSON;
//import com.github.isrsal.logging.RequestWrapper;
//import com.github.isrsal.logging.ResponseWrapper;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.catalina.connector.ResponseFacade;
//import org.apache.logging.log4j.ThreadContext;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URLDecoder;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@Slf4j
////@WebFilter(filterName="logFilter",urlPatterns="/*")
//public class MyFilter2 implements Filter {
//
//    private static final String ignoreUrlRegex = ".*((pay/)|(/index)|(/index/.*)|([.]((html)|(jsp)|(css)|(js)|(gif)|(png))))$";
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        ThreadContext.put("TId", UUID.randomUUID().toString());
//        ResponseWrapper  responseWrapper = new ResponseWrapper (Thread.currentThread().getId(), (HttpServletResponse) servletResponse);
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        RequestWrapper requestWrapper = new RequestWrapper(Thread.currentThread().getId(), httpServletRequest);
//
//        // 请求html页面、js不打印日志
//        if (httpServletRequest.getRequestURI().matches(ignoreUrlRegex)) {
//            ThreadContext.clearAll();
//            filterChain.doFilter(servletRequest, responseWrapper);
//            return;
//        }
//
//        Map params;
//        // 记录入参
//        log.info("请求的URL：" + httpServletRequest.getRequestURI());
//
//        filterChain.doFilter(requestWrapper, responseWrapper);
//
//        // 打印from格式的入参信息
//        params = servletRequest.getParameterMap();
//        if (null != params && params.size() != 0) {
//            log.info("入参：" + JSON.toJSONString(params));
//        } else {
//            // 打印json格式的入参信息
//            String charEncoding = requestWrapper.getCharacterEncoding() != null ? requestWrapper.getCharacterEncoding() : "UTF-8";
//            log.info("入参" + new String(requestWrapper.toByteArray(), charEncoding));
//        }
//
//        // 记录出参
//        String outParam = new String();
//        // 记录出参响应头
//        params = new HashMap();
//        // 如果响应头存在errorCode则打印，除文件下载外均不存在
//        try {
//            params.put("errorCode", ((ResponseFacade) servletResponse).getHeader("errorCode"));
//            params.put("errorMsg", (URLDecoder.decode(((ResponseFacade) servletResponse).getHeader("errorMsg"), "UTF-8")));
//            outParam = JSON.toJSONString(params);
//        } catch (Exception e) {
//        }
//
//        // 记录出参响应体
//        if (params.size() < 2) {
//            outParam = outParam + new String(responseWrapper.toByteArray(), responseWrapper.getCharacterEncoding());
//        }
//
//        log.info("出参：" + outParam);
//
//        ThreadContext.clearAll();
//    }
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void destroy() {
//    }
//}