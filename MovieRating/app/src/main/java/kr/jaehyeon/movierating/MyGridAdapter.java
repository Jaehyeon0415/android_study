package kr.jaehyeon.movierating;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridAdapter extends BaseAdapter {
    private Context context;
    private MyDBHelper dbHelper;
    private SQLiteDatabase sqlDB;
    private int k = 0;

    public MyGridAdapter(Context c, MyDBHelper myDBHelper) {
        context = c;
        dbHelper = myDBHelper;
    }

    // 이미지 리스트
    private Integer[] posterID = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10
    };
    // 이미지 제목 리스트
    private String[] posterName = {
            "제목0","제목1", "제목2", "제목3",
            "제목4", "제목5", "제목6",
            "제목7", "제목8", "제목9"
    };

    // 이미지 좋아요 카운트
    private int[] posterCount = new int[10];

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(200,300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[position]);

        final int pos = position;

        // 영화 이미지 클릭 시
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = View.inflate(context, R.layout.dialog, null);
                TextView name = dialogView.findViewById(R.id.posterName);
                final TextView count = dialogView.findViewById(R.id.likeCount);

                // 디비에서 영화 이름에 맞는 좋아요수 가져와 셋팅한다.
                sqlDB = dbHelper.getWritableDatabase();
                Cursor c = sqlDB.rawQuery("SELECT gNumber FROM groupTBL WHERE gName='" + posterName[pos] + "';", null);
                while (c.moveToNext()) {
                    count.setText(String.valueOf(c.getInt(0)));
                    k = c.getInt(0);
                }

                // 영화 제목 셋팅
                name.setText(posterName[pos]);

                // 다이얼로그 띄우기
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dlg.setView(dialogView);
                dlg.show();

                // 좋아요 이미지 클릭 시
                ImageView img = dialogView.findViewById(R.id.likeImg);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        k++;
                        count.setText(String.valueOf(k));
                        sqlDB.execSQL("UPDATE groupTBL SET gNumber=" + k + " WHERE gName='" + posterName[pos] + "';");
                    }
                });
            }
        });

        return imageView;
    }
}
