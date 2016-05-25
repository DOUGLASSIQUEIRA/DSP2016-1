package dsp.grupointegrado.br.aawbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bhpachulski on 5/25/2016.
 */
public abstract class DAO extends SQLiteOpenHelper {

    public static final String nome = "Banco";
    public static final int version = 1;

    public DAO(Context context) {
        super(context, nome, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_ESTADO = "CREATE TABLE Estado (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT)";
        String SQL_CIDADE = "CREATE TABLE Cidade (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, " +
                " codEstado INTEGER, FOREIGN KEY(codEstado) REFERENCES Estado(cod))";

        sqLiteDatabase.execSQL(SQL_ESTADO);
        sqLiteDatabase.execSQL(SQL_CIDADE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
