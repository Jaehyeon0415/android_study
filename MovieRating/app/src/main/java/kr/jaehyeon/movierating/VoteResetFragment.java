package kr.jaehyeon.movierating;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class VoteResetFragment extends Fragment {
    private MyDBHelper dbHelper;
    private SQLiteDatabase sqlDB, sqlDB1;

    public VoteResetFragment(MyDBHelper myDBHelper) {
        dbHelper = myDBHelper;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vote_reset, container, false);

        TextView name = rootView.findViewById(R.id.name);
        TextView like = rootView.findViewById(R.id.like);

        String n = "제목\n=============\n";
        String l = "선호도\n=============\n";

        sqlDB1 = dbHelper.getWritableDatabase();
        sqlDB = dbHelper.getReadableDatabase();

        sqlDB1.execSQL("UPDATE groupTBL SET gNumber=0;");

        Cursor cursor = sqlDB.rawQuery("SELECT * FROM groupTBL", null);
        while (cursor.moveToNext()) {
            n += cursor.getString(0) + "\r\n";
            l += cursor.getString(1) + "\r\n";
        }

        name.setText(n);
        like.setText(l);

        cursor.close();
        sqlDB.close();
        sqlDB1.close();
        return rootView;
    }
}
