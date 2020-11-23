package kr.jaehyeon.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터 앱");

        GridView gridView = findViewById(R.id.gridView1);

        MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter(MainActivity.this);
        gridView.setAdapter(myGridViewAdapter);
    }
}