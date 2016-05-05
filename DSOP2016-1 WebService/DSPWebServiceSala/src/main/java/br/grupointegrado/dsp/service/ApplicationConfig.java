package br.grupointegrado.dsp.service;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author bhpachulski
 */
@ApplicationPath("service")
public class ApplicationConfig extends Application {
    
    Set<Class<?>> resources = new java.util.HashSet<>();

    @Override
    public Set<Class<?>> getClasses() {
        
        resources.add(br.grupointegrado.dsp.service.ClienteService.class);
        
        try {
            resources.add(Class.forName("org.glassfish.jersey.jackson.JacksonFeature"));
        } catch (ClassNotFoundException ex) {}
        
        return resources;
    }
    
}
