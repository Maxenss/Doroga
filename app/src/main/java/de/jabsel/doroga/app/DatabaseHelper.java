package de.jabsel.doroga.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Yashik on 22.05.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usersbank.db";//название банка данных
    private static final int SCHEMA = 1; //версия бд
    static final String TABLE = "users"; //название таблицы в бд
    //название столбцов:
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ORT = "ort";
    // ...4...

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users (" + COLUMN_ID
                + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME
                + "TEXT, " + COLUMN_ORT + " INTEGER);"); // ...5...-DatBaseAdapter
        //добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_ORT  + ") VALUES ('Tom Smit', Ketsch);");// ...6...
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
