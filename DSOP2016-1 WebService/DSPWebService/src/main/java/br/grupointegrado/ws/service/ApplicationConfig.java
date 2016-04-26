package br.grupointegrado.ws.service;

import java.util.Set;
import javax.ejb.Startup;
import javax.ws.rs.core.Application;

/**
 *
 * @author bhpachulski
 */
@Startup
@javax.ws.rs.ApplicationPath("services")
public class ApplicationConfig extends Application {

    public static final String CHARSET = "; charset=utf-8";

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        try {
            resources.add(Class.forName("org.glassfish.jersey.jackson.JacksonFeature"));
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro no ApplicationConfig ...");
        }
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.grupointegrado.ws.service.impl.AlunoService.class);
    }

}
