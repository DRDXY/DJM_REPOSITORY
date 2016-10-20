package com.raze.common.tomcat;

import java.io.File;

import javax.servlet.ServletException;
 
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
 
/**
 * @author DJM
 */
public class EmbeddedTomcat {
     
    private Logger logger = LoggerFactory.getLogger(EmbeddedTomcat.class); 
     
    private Tomcat tomcat;
     
    private int port;
     
    private static final String tempDir= "src"+File.separatorChar+"main"+File.separatorChar+"webapp";
     
    public EmbeddedTomcat(int port){
        tomcat = new Tomcat();
        this.port = port;
    }
     
    public void startUpTomcat(){
        tomcat.setPort(port);
        try {
            tomcat.addWebapp("", System.getProperty("user.dir")+File.separatorChar+tempDir);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        try {
            StandardServer server = (StandardServer)tomcat.getServer();  
            AprLifecycleListener listener = new AprLifecycleListener();  
            server.addLifecycleListener(listener); 
            tomcat.start();
        } catch (LifecycleException e) {
            logger.info("An exception occurs when start tomcat!");
            e.printStackTrace();
        }
        tomcat.getServer().await();
        logger.info("Tomcat has been started successfully!");
    }
 
    public void shutDownTomcat(){
        try {
            tomcat.stop();
        } catch (LifecycleException e) {
            logger.info("An exception occurs when close tomcat!");
            e.printStackTrace();
        }
        logger.info("Tomcat has been closed!");
    }
}