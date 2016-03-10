package dsp.grupointegrado.br.dsp2016_1;

import android.content.Context;

import java.util.List;

/**
 * Created by bhpachulski on 3/9/2016.
 */
public class ProdutoDAO extends DAO<Produto> {


    public ProdutoDAO(Context context) {
        super(context);
    }

    @Override
    public void alterar() {

    }

    @Override
    public void deletar() {

    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    //    public void salvaProduto (Produto p) {
//
//        ContentValues cv = new ContentValues();
//        cv.put("nome", p.getNome());
//        cv.put("valor", p.getValor());
//
//        getWritableDatabase().insert("Produto", null, cv);
//    }
//
//    public List<Produto> getProdutos() {
//
//        Cursor c = getReadableDatabase().query("Produto",
//                new String[]{"cod", "nome", "valor"}, null, null, null, null, null);
//
//        List<Produto> produtos = new ArrayList<>();
//
//        while (c.moveToNext()) {
//            Produto p = new Produto();
//            p.setCod(c.getInt(0));
//            p.setNome(c.getString(1));
//            p.setValor(c.getDouble(2));
//
//            produtos.add(p);
//        }
//        c.close();
//
//        return produtos;
//    }
}
