package kr.jaehyeon.movierating;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class VoteResultFragment extends Fragment {
    private MyDBHelper dbHelper;
    private SQLiteDatabase sqlDB;

    public VoteResultFragment(MyDBHelper myDBHelper) {
        dbHelper = myDBHelper;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vote_result, container, false);

        TextView textView = rootView.findViewById(R.id.mName);

        RatingBar ratingBar0 = rootView.findViewById(R.id.mRating0);
        RatingBar ratingBar1 = rootView.findViewById(R.id.mRating1);
        RatingBar ratingBar2 = rootView.findViewById(R.id.mRating2);
        RatingBar ratingBar3 = rootView.findViewById(R.id.mRating3);
        RatingBar ratingBar4 = rootView.findViewById(R.id.mRating4);
        RatingBar ratingBar5 = rootView.findViewById(R.id.mRating5);
        RatingBar ratingBar6 = rootView.findViewById(R.id.mRating6);
        RatingBar ratingBar7 = rootView.findViewById(R.id.mRating7);
        RatingBar ratingBar8 = rootView.findViewById(R.id.mRating8);
        RatingBar ratingBar9 = rootView.findViewById(R.id.mRating9);

        int[] countList = new int[10];

        int i = 0;
        sqlDB = dbHelper.getReadableDatabase();

        // 영화 이름 한번에 나타내기
        Cursor cursor = sqlDB.rawQuery("SELECT gName FROM groupTBL;", null);
        String name = "";
        while (cursor.moveToNext()) {
            name += cursor.getString(0) + "\r\n\n";
        }
        textView.setText(name);

        // 영화 좋아요 값 가져오기
        Cursor cursor1 = sqlDB.rawQuery("SELECT gNumber FROM groupTBL;", null);
        while (cursor1.moveToNext()) {
            countList[i] = cursor1.getInt(0);
            i++;
        }

        cursor.close();
        sqlDB.close();

        // ratingBar 값 세팅 (무식하게)
        ratingBar0.setRating(countList[0]);
        ratingBar1.setRating(countList[1]);
        ratingBar2.setRating(countList[2]);
        ratingBar3.setRating(countList[3]);
        ratingBar4.setRating(countList[4]);
        ratingBar5.setRating(countList[5]);
        ratingBar6.setRating(countList[6]);
        ratingBar7.setRating(countList[7]);
        ratingBar8.setRating(countList[8]);
        ratingBar9.setRating(countList[9]);

        return rootView;
    }
}
