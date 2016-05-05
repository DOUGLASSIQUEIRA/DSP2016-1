package dsp.grupointegrado.br.dsp201612bim.service;

import org.androidannotations.rest.spring.annotations.Accept;
import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Put;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

import dsp.grupointegrado.br.dsp201612bim.model.Cliente;

/**
 * Created by bhpachulski on 4/27/2016.
 */
@Rest(rootUrl = "http://10.2.2.35:8080/DSPWebServiceSala/service/cliente", converters = {MappingJackson2HttpMessageConverter.class})
@Accept(MediaType.APPLICATION_JSON)
public interface ClienteService {

    @Get("/list")
    List<Cliente> getClientes ();

    @Put("/set")
    Boolean setCliente(@Body Cliente cliente);

}
