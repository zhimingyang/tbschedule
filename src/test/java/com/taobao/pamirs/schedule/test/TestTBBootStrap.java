package com.taobao.pamirs.schedule.test;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import java.util.Hashtable;
import java.util.Properties;

/**
 * TBµƒ≤‚ ‘¿‡
 */
public class TestTBBootStrap {
    public static void main(String args[]) throws Exception {
        PropertyConfigurator.configure("//home/zhiming/git/tbschedule/src/test/resources/log4j.properties");
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "//home/zhiming/git/tbschedule/src/test/resources/spring-config.xml");
        TBScheduleManagerFactory scheduleManagerFactory = new TBScheduleManagerFactory();
        Properties p = new Properties();
        p.put("zkConnectString", "localhost:2181");
        p.put("rootPath", "/taobao-pamirs-schedule/huijin");
        p.put("zkSessionTimeout", "60000");
        p.put("userName", "ScheduleAdmin");
        p.put("password", "password");
        p.put("isCheckParentPath", "true");
        scheduleManagerFactory.setApplicationContext(ctx);
        scheduleManagerFactory.init(p);
        scheduleManagerFactory.setZkConfig((Hashtable)p);
    }
}
