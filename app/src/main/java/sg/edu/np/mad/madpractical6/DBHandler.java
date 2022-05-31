package sg.edu.np.mad.madpractical6;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c) {super (c, "MADPrac6.db", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE User (Name TEXT, Description TEXT, Id INT, Followed BOOLEAN)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS Message");
        onCreate(db);
    }

    public void insertUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO User VALUES( \"" + u.Name + "\", \"" + u.Description + "\", + \"" + u.Id + "\", + \"" + u.Followed + "\")");
        db.close();
    }

    public ArrayList<User> getUsers()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<User> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM USER", null);
        while(cursor.moveToNext())
        {
            User u = new User();
            u.Name = cursor.getString(0);
            u.Description = cursor.getString(1);
            u.Id = cursor.getInt(2);
            u.Followed = Boolean.parseBoolean(cursor.getString(3));
            list.add(u);
        }

        return list;
    }

    public void updateUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE User SET Followed = \""+ u.Followed +"\" " +  "WHERE Id = \""+ u.Id +"\"");
        db.close();
    }

    public int CountUsers()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User", null);
        return cursor.getCount();       //Returns no. of rows
    }
}
