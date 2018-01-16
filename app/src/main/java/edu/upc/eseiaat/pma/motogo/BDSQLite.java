package edu.upc.eseiaat.pma.motogo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Javi on 10/01/2018.
 */

public class BDSQLite extends SQLiteOpenHelper {

    private String sql = "create table eventos("+
            "idEvent int identity," +
            "nombreEvento varchar (40)," +
            "ubicacion varchar (60)," +
            "fechadesde date," +
            "horadesde time," +
            "fechahasta date," +
            "horahasta time," +
            "descripcion varchar(60));";
  /*private String sql = "CREATE table eventos (idEvento INTEGER not null auto_increment ," +
            "nombreEvento varchar(40)," +
            "ubicacion varchar(60)," +
            "fechadesde text," +
            "horadesde text," +
            "fechahasta text," +
            "horahasta text," +
            "descripcion text, PRIMARY KEY (idEvento));";*/

    public BDSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
