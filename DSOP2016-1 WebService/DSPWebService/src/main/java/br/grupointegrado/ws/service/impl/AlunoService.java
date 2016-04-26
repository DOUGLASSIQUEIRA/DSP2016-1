package br.grupointegrado.ws.service.impl;

import br.grupointegrado.ws.model.Aluno;
import br.grupointegrado.ws.service.ApplicationConfig;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author bhpachulski
 */
@Path("aluno")
public class AlunoService {

    @Path("list")
    @GET 
    @Produces(MediaType.APPLICATION_JSON + ApplicationConfig.CHARSET)
    public List<Aluno> getAlunos()  {

        List<Aluno> nomes = new ArrayList<>();
        nomes.add(new Aluno("00.0000-0", "Bruno H. P. Camara"));
        nomes.add(new Aluno("09.4340-7", "João da 250"));

        return nomes;
    }
    
    @Path("test/{var}")
    @GET 
    @Produces(MediaType.APPLICATION_JSON + ApplicationConfig.CHARSET)
    public String test(@PathParam("var") String var, @PathParam("var2") String var2)  {

        return "Olá Mundo" + var + var2;
    }
    
    @Path("testObjeto") 
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ApplicationConfig.CHARSET)
    public List<Aluno> test(List<Aluno> as)  {
        
        for (int i = 0; i < 10; i++) {
            as.add(new Aluno("00.0000-0", "Bruno H. P. Camara"));
            as.add(new Aluno("09.4340-7", "João da 250"));
        }
        
        return as;
    }

}
