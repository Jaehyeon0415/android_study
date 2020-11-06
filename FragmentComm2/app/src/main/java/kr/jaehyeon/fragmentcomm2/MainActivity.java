package kr.jaehyeon.fragmentcomm2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener {
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MainActivity에 Main Fragment 추가
        MainFragment mainFragment = new MainFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, mainFragment).addToBackStack(null).commit();
    }

    @Override
    public void onInputMain(CharSequence input, String name) {
        switch (name) {
            case "A":
                FragmentA fragmentA = new FragmentA();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragmentA).addToBackStack(null).commit();
                fragmentA.updateEditTextA(input);
                break;
            case "B":
                FragmentB fragmentB = new FragmentB();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragmentB).addToBackStack(null).commit();
                fragmentB.updateEditTextA(input);
                break;
            case "C":
                FragmentC fragmentC = new FragmentC();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragmentC).addToBackStack(null).commit();
                fragmentC.updateEditTextA(input);
                break;
        }
    }
}