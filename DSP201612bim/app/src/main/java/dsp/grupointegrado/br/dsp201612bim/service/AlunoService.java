package dsp.grupointegrado.br.dsp201612bim.service;

import org.androidannotations.rest.spring.annotations.Accept;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

import dsp.grupointegrado.br.dsp201612bim.model.Aluno;

/**
 * Created by bhpachulski on 4/25/2016.
 */

@Rest(rootUrl = "http://10.1.0.82:8080/DSPWebService/services/aluno", converters = {MappingJackson2HttpMessageConverter.class})
@Accept(MediaType.APPLICATION_JSON)
public interface AlunoService {

    @Get("/list")
    List<Aluno> list ();

    @Get("/test")
    String teste ();

}
