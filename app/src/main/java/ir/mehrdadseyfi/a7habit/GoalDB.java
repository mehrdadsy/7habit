package ir.mehrdadseyfi.a7habit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Mehrdad on 8/16/2017.
 */

public class GoalDB extends SQLiteOpenHelper {
    String db_create_query="" +

            "CREATE TABLE Goal_tbl (" +

            " _id INTEGER PRIMARY KEY  AUTOINCREMENT  ," +

            " name TEXT ," +

            " Date TEXT,  "
            + "Cat TEXT" + ")" +

            "";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(db_create_query);

    }

    public GoalDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserToDB(String name, String Date, String cat) {

        String insertQuery = "INSERT INTO Goal_tbl (name, Date, Cat) VALUES ("
                + "'" + name + "','" + Date + "','" + cat + "')";

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(insertQuery);

        db.close();

    }

    public String getGoal() {

        String test = "";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT name from " + "  Goal_tbl", null);

        while (cursor.moveToNext()) {

            test = cursor.getString(0);

        }

        db.close();

        return test;

    }
}
