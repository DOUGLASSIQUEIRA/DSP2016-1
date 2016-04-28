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
        try {
            addRestResourceClasses(resources);            
        } catch (ClassNotFoundException ex) {}
        
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) throws ClassNotFoundException {
        resources.add(br.grupointegrado.dsp.service.ClienteService.class);
        resources.add(Class.forName("org.glassfish.jersey.jackson.JacksonFeature"));
    }
    
}
