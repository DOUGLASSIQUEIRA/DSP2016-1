package dsp.grupointegrado.br.aawbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhpachulski on 5/25/2016.
 */
public class EstadoDAO extends DAO {

    private static String TB_NOME = "Estado";

    public EstadoDAO(Context context) {
        super(context);
    }

    public void add (Estado estado) {
        ContentValues cv = new ContentValues();
        cv.put("nome", estado.getNome());

        super.getWritableDatabase().insert(TB_NOME, null, cv);
    }

    public void update (Estado estado) {
        ContentValues cv = new ContentValues();
        cv.put("cod", estado.getCod());
        cv.put("nome", estado.getNome());

        super.getWritableDatabase().update(TB_NOME, cv, "cod = ?",
                new String[]{String.valueOf(estado.getCod())});
    }

    public void delete (Estado estado) {
        super.getWritableDatabase().delete(TB_NOME, "cod = ?",
                new String[] {String.valueOf(estado.getCod())});
    }

    public List<Estado> list () {
        List<Estado> estados = new ArrayList<>();
        Cursor c = super.getReadableDatabase().rawQuery("SELECT * FROM Estado", null);

        while (c.moveToNext()) {
            Estado e = new Estado();
            e.setCod(c.getInt(c.getColumnIndex("cod")));
            e.setNome(c.getString(c.getColumnIndex("nome")));

            estados.add(e);
        }
        c.close();

        return estados;
    }

}
