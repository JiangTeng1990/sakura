package com.sakura;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class MyStart {
	public static void main(String[] args) throws Exception {
		 long begin = System.currentTimeMillis();

			WebAppContext webapp = new WebAppContext("webapp", "/sakura");
			webapp.setDefaultsDescriptor("./webapp/WEB-INF/webdefault.xml");
			
			// add mock web.xml here to replace the default web.xml under webapp and enable mockMode
			webapp.setDescriptor("./webapp/WEB-INF/web.xml");

	        Server server = new Server(8080);
	        server.setHandler(webapp);
			server.start();
	        System.out.println("Jetty Server started, use " + (System.currentTimeMillis() - begin) + " ms");
	}
}
