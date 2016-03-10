package dsp.grupointegrado.br.dsp2016_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by bhpachulski on 2/24/2016.
 */
public abstract class DAO<T> extends SQLiteOpenHelper {

    private static final String NAME = "MEU_BANQUINHUXUZINHUXU";
    private static final int VERSION = 1;

    private Class<T> tipo;

    public DAO(Context context, Class<T> tipo) {
        super(context, NAME, null, VERSION);
        this.tipo = tipo;
    }

    public void salvar (T objeto) throws IllegalAccessException {

        ContentValues cv = new ContentValues();
        for (Field f : FieldUtils.getAllFieldsList(getTipo())) {
            if (!f.isAnnotationPresent(Id.class))
                cv.put(f.getName(), String.valueOf(FieldUtils.readField(f, objeto, true)));
        }

        getWritableDatabase().insert(tipo.getSimpleName(), null, cv);
    }

    public abstract void alterar ();

    public abstract void deletar ();

    public abstract List<T> listar ();

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL = "CREATE TABLE Produto (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, valor REAL)";

        sqLiteDatabase.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {}


    public Class<T> getTipo() {
        return this.tipo;
    }
}
