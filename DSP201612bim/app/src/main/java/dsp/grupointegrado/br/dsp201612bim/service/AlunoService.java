package dsp.grupointegrado.br.dsp201612bim.service;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.util.List;

import dsp.grupointegrado.br.dsp201612bim.model.Aluno;

/**
 * Created by bhpachulski on 4/25/2016.
 */

@Rest(rootUrl = "http://10.2.2.36:8080/DSPWebService/services/aluno", converters = {ByteArrayHttpMessageConverter.class,
        FormHttpMessageConverter.class, StringHttpMessageConverter.class})
public interface AlunoService {

    @Get("/list")
    List<Aluno> list ();

    @Get("/test")
    String teste ();

}
