package dsp.grupointegrado.br.dsp2016_1;

import java.io.Serializable;

/**
 * Created by bhpachulski on 2/24/2016.
 */
public class Produto implements Serializable {

    private int cod;
    private String nome;
    private double valor;


    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" + this.getCod() + "} " + this.getNome();
    }
}
