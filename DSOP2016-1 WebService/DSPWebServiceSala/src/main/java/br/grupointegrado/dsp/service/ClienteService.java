package br.grupointegrado.dsp.service;

import br.grupointegrado.dsp.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author bhpachulski
 */
@Path("cliente")
public class ClienteService {

    private static List<Cliente> clientes;

    static {

        clientes = new ArrayList<>();

        clientes.add(new Cliente(1, "bruno"));
    }

    @Path("list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes() {
        return clientes;
    }

    @Path("set")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean setCliente(Cliente cliente) {
        try {
            clientes.add(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Path("get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam("id") int id) {
        
        for (Cliente c : clientes) {
            if (c.getId() == id)
                return c;
        }
        
        throw new RuntimeException("Cliente não encontrado");
    }

}
