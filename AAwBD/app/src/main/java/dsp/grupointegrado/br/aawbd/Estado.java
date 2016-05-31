package dsp.grupointegrado.br.aawbd;

import java.io.Serializable;

/**
 * Created by bhpachulski on 5/25/2016.
 */
public class Estado implements Serializable {

    private int cod;
    private String nome;

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

    @Override
    public String toString() {
        return this.getNome();
    }
}
