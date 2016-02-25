package dsp.grupointegrado.br.dsp2016_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhpachulski on 2/24/2016.
 */
public class Conexao extends SQLiteOpenHelper {

    private static final String NAME = "MEU_BANQUINHUXUZINHUXU";
    private static final int VERSION = 1;

    public Conexao(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL = "CREATE TABLE Produto (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, valor REAL)";

        sqLiteDatabase.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {}

    public void salvaProduto (Produto p) {

        ContentValues cv = new ContentValues();
        cv.put("nome", p.getNome());
        cv.put("valor", p.getValor());

        getWritableDatabase().insert("Produto", null, cv);
    }

    public List<Produto> getProdutos() {

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

}
