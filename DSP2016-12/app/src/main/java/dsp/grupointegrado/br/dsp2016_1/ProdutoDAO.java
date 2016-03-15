package dsp.grupointegrado.br.dsp2016_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhpachulski on 3/9/2016.
 */
public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO(Context context) {
        super(context, Produto.class);
    }

    public List<Produto> listar() {

        Cursor c = getReadableDatabase().query("Produto",
                new String[]{"cod", "nome", "valor"}, null, null, null, null, null);

        List<Produto> produtos = new ArrayList<>();

        while (c.moveToNext()) {
            Produto p = new Produto();
            p.setCod(c.getInt(0));
            p.setNome(c.getString(1));
            p.setValor(c.getDouble(2));

            produtos.add(p);
        }
        c.close();

        return produtos;
    }

//    @Override
//    public void salvaProduto (Produto p) {
//
//        ContentValues cv = new ContentValues();
//        cv.put("nome", p.getNome());
//        cv.put("valor", p.getValor());
//
//        getWritableDatabase().insert("Produto", null, cv);
//    }

//    @Override
//    public void alterar(Produto produto) {
//
//        ContentValues cv = new ContentValues();
//        cv.put("nome", produto.getNome());
//        cv.put("valor", produto.getValor());
//
//        super.getWritableDatabase().update("Produto", cv, "cod = ?",
//                new String[]{String.valueOf(produto.getCod())});
//    }
}
