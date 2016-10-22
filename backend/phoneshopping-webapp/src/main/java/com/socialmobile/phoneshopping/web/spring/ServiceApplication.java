package com.socialmobile.phoneshopping.web.spring;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class ServiceApplication extends ResourceConfig {
    public ServiceApplication() {
        packages(true, "com.socialmobile.phoneshopping.web.resources");
    }
}
