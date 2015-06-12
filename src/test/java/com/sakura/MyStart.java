package com.sakura;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class MyStart {
	public static void main(String[] args) {
		 long begin = System.currentTimeMillis();

			WebAppContext webapp = new WebAppContext("src/main/webapp", "/memcache-test");
			webapp.setDefaultsDescriptor("./src/main/webapp/WEB-INF/web.xml");
			
			// add mock web.xml here to replace the default web.xml under webapp and enable mockMode
			webapp.setDescriptor("./src/test/resources/runtime/web.local.xml");

	        Server server = new Server(8080);
	        server.setHandler(webapp);
	        try {
				server.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        System.out.println("Jetty Server started, use " + (System.currentTimeMillis() - begin) + " ms");
	}
}
