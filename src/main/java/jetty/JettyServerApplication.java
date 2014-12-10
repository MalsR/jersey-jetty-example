package jetty;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServerApplication {

    //WIP
    public static void main(String[] args) {
        Server jettyServer = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //possible duplicate as root path added below
        context.setContextPath("/");

        jettyServer.setHandler(context);

        ServletHolder servletHolder = new ServletHolder(new ServletContainer());
        //servletHolder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");

        //scan the following folder for jersey resources with either @Path or @Provider
        servletHolder.setInitParameter(PackagesResourceConfig.PROPERTY_PACKAGES, "jersey.resources");
        servletHolder.setInitOrder(1);

        context.addServlet(servletHolder, "/*");

        try {
            jettyServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            jettyServer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
