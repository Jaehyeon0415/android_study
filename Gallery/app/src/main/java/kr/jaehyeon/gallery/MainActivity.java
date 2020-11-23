package kr.jaehyeon.gallery;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Gallery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery gallery = findViewById(R.id.gallery1);
        MyGalleryAdapter myGalleryAdapter = new MyGalleryAdapter(MainActivity.this);
        gallery.setAdapter(myGalleryAdapter);
    }
}