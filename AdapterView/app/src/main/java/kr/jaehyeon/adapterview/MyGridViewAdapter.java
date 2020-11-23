package kr.jaehyeon.adapterview;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MyGridViewAdapter extends BaseAdapter {
    private Context context;

    public MyGridViewAdapter(Context c) {
        context = c;
    }

    private Integer[] posterID = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10, R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
            R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
            R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
    };

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
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = View.inflate(context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dlg.setTitle("큰 포스터");
                dlg.setIcon(R.drawable.movie_icon);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

        return imageView;
    }
}
