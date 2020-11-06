package kr.jaehyeon.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerA, fragmentA);
        fragmentTransaction.replace(R.id.containerB, fragmentB);
        fragmentTransaction.commit();

    }

    @Override
    public void onInputA(CharSequence input) {
        fragmentB.updateEditTextB(input);
    }

    @Override
    public void onInputB(CharSequence input) {
        fragmentA.updateEditTextA(input);
    }
}