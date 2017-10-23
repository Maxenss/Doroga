package de.jabsel.doroga.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yashik on 22.05.2017.
 */

public class DatabaseAdapter {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }

    public  DatabaseAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    private Cursor getAllEntries(){
        String[] columns = new String[] {DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_ORT};
        //...7...
        return database.query(DatabaseHelper.TABLE, columns, null, null, null, null, null);
    }
    public List<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        Cursor cursor = getAllEntries();
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
                int ort = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ORT));
               //...8...
                users.add(new User(id, name, ort));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    }
    public long getCount(){
        return DatabaseUtils.queryNumEntries(database,DatabaseHelper.TABLE);
    }

    public User getUser(long id){
        User user = null;
        String query = String.format("SELECT * FROM %s WHERE %s=?",DatabaseHelper.TABLE,
DatabaseHelper.COLUMN_ID);
        Cursor cursor = database.rawQuery(query, new  String[]{ String.valueOf(id)});
        if (cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            int ort = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ORT));
            //...9...
            user = new User(id, name, ort);
        }
        cursor.close();
        return user;
    }

    public long insert(User user){

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, user.getName());
        cv.put(DatabaseHelper.COLUMN_ORT, user.getOrt());
       //...10

        return database.insert(DatabaseHelper.TABLE, null, cv);
    }

    public long update(User user) {

        String whereClause = DatabaseHelper.COLUMN_ID + "=" + String.valueOf(user.getId());
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, user.getName());
        cv.put(DatabaseHelper.COLUMN_ORT, user.getOrt());
        //...11 -UserActivity(RegAct)
        return database.update(DatabaseHelper.TABLE, cv, whereClause, null);
    }
}
