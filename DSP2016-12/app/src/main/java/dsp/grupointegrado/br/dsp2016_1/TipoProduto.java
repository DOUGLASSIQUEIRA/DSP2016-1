package dsp.grupointegrado.br.dsp2016_1;

import java.io.Serializable;

/**
 * Created by bhpachulski on 3/14/2016.
 */
public class TipoProduto implements Serializable {

    @Id
    private int id;

    private String nome;
    private String descricao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
