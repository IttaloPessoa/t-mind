package br.com.ufpb.ittalopessoa.t_mind.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ittalo Pessoa on 06/05/2016.
 */
public class DBCore extends SQLiteOpenHelper {


    private static final String DBNAME ="t-mindDB";
    private static final int DBVERSION = 2;
    private DBCode code;

    public DBCore(Context context) {
        super(context,DBNAME, null, DBVERSION);
        code = new DBCode();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String s : code.createTables()){
            db.execSQL("CREATE TABLE " + s);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE usuario");
        db.execSQL("DROP TABLE pergunta");
        db.execSQL("DROP TABLE resposta");

    }
}
