package kr.jaehyeon.movierating;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context) {
        super(context, "groupDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("databaseApp", "MyDBHelper : onCreate");
        sqLiteDatabase.execSQL("CREATE TABLE groupTBL ( gName char(20) PRIMARY KEY, gNumber integer );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("databaseApp", "MyDBHelper : onUpgrade");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS groupTBL");
        onCreate(sqLiteDatabase);
    }
}
