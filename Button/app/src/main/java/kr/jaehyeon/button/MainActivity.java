package kr.jaehyeon.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button, button2, button3, button4, button5, button6, button7, button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰의 주소를 받아온다.
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);


        // 리스너 객체를 생성
        BtnListener listener = new BtnListener();
        BtnListener2 listener2 = new BtnListener2();
        BtnListener34 listener34 = new BtnListener34();

        // 리스너를 버튼 객체에 설정한다.
        button.setOnClickListener(listener);
        button2.setOnClickListener(listener2);
        button3.setOnClickListener(listener34);
        button4.setOnClickListener(listener34);

    }

    // 첫 번째 버튼과 연결된 리스너
    class BtnListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            textView.setText("첫 번째 버튼을 클릭했습니다.");
        }
    }

    // 두 번째 버튼과 연결된 리스너
    class BtnListener2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            textView.setText("두 번째 버튼을 클릭했습니다.");
        }
    }

    // 세 번째와 네 번째 버튼과 연결된 리스너
    class BtnListener34 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // 이벤트가 발생된 뷰의 아이디값을 가져온다.
            int id = view.getId();
            switch (id) {
                case R.id.button3:
                    textView.setText("세 번째 버튼을 클릭했습니다.");
                    break;
                case R.id.button4:
                    textView.setText("네 번째 버튼을 클릭했습니다.");
                    break;
            }
        }
    }
    // 다섯 번째 버튼을 누르면 호출되는 메서드
    public void btn5Method(View view) {
        textView.setText("다섯 번째 버튼을 클릭했습니다.");
    }
    // 여섯 번째 버튼을 누르면 호출되는 메서드
    public void btn6Method(View view) {
        textView.setText("여섯 번째 버튼을 클릭했습니다.");
    }
    // 일곱 번쨰, 여덟 번째 버튼을 누르면호출되는 메서드
    public void btn78Method(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button7:
                textView.setText("일곱 번째 버튼을 클릭했습니다.");
                break;
            case R.id.button8:
                textView.setText("여덟 번째 버튼을 클릭했습니다.");
                break;
        }
    }
}