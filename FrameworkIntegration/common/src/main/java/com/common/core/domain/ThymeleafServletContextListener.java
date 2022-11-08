package com.common.core.domain;

import com.alibaba.druid.pool.ha.PropertiesUtils;
import com.github.pagehelper.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ThymeleafServletContextListener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(ThymeleafServletContextListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        logger.info("----------:ServletContext销毁");
    }
}

