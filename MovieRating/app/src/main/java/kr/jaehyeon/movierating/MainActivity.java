package kr.jaehyeon.movierating;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    SQLiteDatabase sqlDB;
    MyDBHelper myDBHelper;

    // 이미지 제목 리스트
    private String[] name = {
            "제목0","제목1", "제목2", "제목3",
            "제목4", "제목5", "제목6",
            "제목7", "제목8", "제목9"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("영화투표 앱");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24);

        myDBHelper = new MyDBHelper(MainActivity.this);
        sqlDB = myDBHelper.getWritableDatabase();
        myDBHelper.onUpgrade(sqlDB, 1, 2);
        for (int i = 0; i < name.length; i++) {
            sqlDB.execSQL("INSERT INTO groupTBL VALUES ('" + name[i] + "', " + 0 + ");");
            Log.i("movie name", name[i]);
        }
        sqlDB.close();

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_vote:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new VoteFragment(myDBHelper))
                                .commit();
                        break;
                    case R.id.nav_voteResult:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new VoteResultFragment(myDBHelper))
                                .commit();
                        break;
                    case R.id.nav_voteReset:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new VoteResetFragment(myDBHelper))
                                .commit();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}