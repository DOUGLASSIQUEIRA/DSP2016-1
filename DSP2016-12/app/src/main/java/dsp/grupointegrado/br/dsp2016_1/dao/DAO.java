package dsp.grupointegrado.br.dsp2016_1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by bhpachulski on 2/24/2016.
 */
public abstract class DAO<T> extends SQLiteOpenHelper {

    private static final String NAME = "MEU_BANQUINHUXUZINHUXU";
    private static final int VERSION = 3;

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

    public void alterar (T objeto) throws IllegalAccessException {

        ContentValues cv = new ContentValues();
        for (Field f : FieldUtils.getAllFieldsList(getTipo())) {

            if (!f.isAnnotationPresent(Id.class))
                cv.put(f.getName(), String.valueOf(FieldUtils.readField(f, objeto, true)));

        }

        StringBuilder clausulaWhere = new StringBuilder();
        String[] valorWhere = new String[]{};
        for (Field f : FieldUtils.getAllFieldsList(getTipo())) {

            if (f.isAnnotationPresent(Id.class)) {
                clausulaWhere.append(f.getName()).append("=?");
                valorWhere = new String[]{String.valueOf(FieldUtils.readField(f, objeto, true))};
            }

        }

        getWritableDatabase().update(getTipo().getSimpleName(), cv,
                clausulaWhere.toString(), valorWhere);

    }

    public void deletar (T objeto) throws IllegalAccessException{

        StringBuilder clausulaWhere = new StringBuilder();
        String[] valorWhere = new String[]{};
        for (Field f : FieldUtils.getAllFieldsList(getTipo())) {

            if (f.isAnnotationPresent(Id.class)) {
                clausulaWhere.append(f.getName()).append("=?");
                valorWhere = new String[]{String.valueOf(FieldUtils.readField(f, objeto, true))};
            }

        }

        getWritableDatabase().delete(getTipo().getSimpleName(), clausulaWhere.toString(),
                valorWhere);

    }

    public abstract List<T> listar ();

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_PRODUTO = "CREATE TABLE Produto (cod INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, valor REAL)";

        sqLiteDatabase.execSQL(SQL_PRODUTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String SQL_TIPOPRODUTO = "CREATE TABLE TipoProduto (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, descricao TEXT)";
        sqLiteDatabase.execSQL(SQL_TIPOPRODUTO);
    }

//    public String getCreateTable () throws IOException {
//        ClassPath classpath = ClassPath.from(Thread.currentThread().getContextClassLoader());
//
//        for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClasses("dsp.grupointegrado.br.dsp2016_1.model")) {
//
//        }
//        return classpath.getTopLevelClasses("dsp.grupointegrado.br.dsp2016_1.model").toString();
//    }

    public Class<T> getTipo() {
        return this.tipo;
    }
}
