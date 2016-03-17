package dsp.grupointegrado.br.dsp2016_1.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import dsp.grupointegrado.br.dsp2016_1.model.TipoProduto;

/**
 * Created by bhpachulski on 3/14/2016.
 */
public class TipoProdutoDAO extends DAO<TipoProduto> {

    public TipoProdutoDAO(Context context) {
        super(context, TipoProduto.class);
    }

    @Override
    public List<TipoProduto> listar() {

        Cursor c = getReadableDatabase().query("TipoProduto",
                new String[]{"id", "nome", "descricao"}, null, null, null, null, null);

        List<TipoProduto> tps = new ArrayList<>();

        while (c.moveToNext()) {
            TipoProduto tp = new TipoProduto();
            tp.setId(c.getInt(0));
            tp.setNome(c.getString(1));
            tp.setDescricao(c.getString(2));


            tps.add(tp);
        }
        c.close();

        return tps;

    }
}
