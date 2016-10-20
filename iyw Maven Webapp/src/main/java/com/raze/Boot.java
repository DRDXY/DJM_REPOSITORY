package com.raze;

import com.raze.common.tomcat.EmbeddedTomcat;

/**
 * @author DJM
 */
public class Boot {
 
    public static void main(String[] args) {
         
        EmbeddedTomcat tomcat = new EmbeddedTomcat(19233);
         
        tomcat.startUpTomcat();
        
    }
}