package com.common.Interceptor;

import com.common.Filter.TimeFilter;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Logger;

public class MyInterceptor implements HandlerInterceptor {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

    // 实现HandlerInterceptor接口
    /**
     * 访问控制器方法前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        LOG.info(new Date() + "--preHandle:" + request.getRequestURL());
        return true;
    }

    /**
     * 访问控制器方法后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        LOG.info(new Date() + "--postHandle:" + request.getRequestURL());
    }

    /**
     * postHandle方法执行完成后执行，一般用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        LOG.info(new Date() + "--afterCompletion:" + request.getRequestURL());
    }
}

