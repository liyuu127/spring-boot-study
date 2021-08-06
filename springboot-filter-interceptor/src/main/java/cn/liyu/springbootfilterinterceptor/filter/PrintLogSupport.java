//package cn.liyu.springbootfilterinterceptor.filter;
//
//import com.github.isrsal.logging.ResponseWrapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author liyu
// * date 2020/9/11 16:58
// * description
// */
//@Configuration
//@Slf4j
//public class PrintLogSupport {
//
//    @Async("customThreadPoolExecutor")
//    public void printLog(Map<String, String[]> parameterMap, ResponseWrapper responseWrapper) {
//
//        try {
//            String s = new String(responseWrapper.toByteArray(), responseWrapper.getCharacterEncoding());
//            log.info("print trace log  ==> {}  ", parameterMap.size());
//            log.info("print trace log  ==> {}  ", s);
//        } catch (Exception e) {
//            log.error("trace log error : ", e);
//        }
//    }
//
//
//
//    private Map<String, String> convertRequestParameters(Map<String, String[]> parameterMap) {
//        if (parameterMap == null) {
//            return null;
//        }
//        Map<String, String> converts = new HashMap<>();
//        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
//            converts.put(entry.getKey(), entry.getValue()[0]);
//        }
//        return converts;
//    }
//
//}
