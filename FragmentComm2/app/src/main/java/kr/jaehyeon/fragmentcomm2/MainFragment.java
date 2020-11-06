package kr.jaehyeon.fragmentcomm2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private EditText editText;
    private MainFragmentListener listener = null;
    private CharSequence input = "";

    public interface MainFragmentListener {
        void onInputMain(CharSequence input, String name);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentListener) {
            listener = (MainFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement MainFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        editText = view.findViewById(R.id.editText);
        Button buttonA = view.findViewById(R.id.buttonA);
        Button buttonB = view.findViewById(R.id.buttonB);
        Button buttonC = view.findViewById(R.id.buttonC);

        // buttonA 클릭
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = editText.getText();
                listener.onInputMain(input, "A");
            }
        });

        // buttonB 클릭
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = editText.getText();
                listener.onInputMain(input, "B");
            }
        });

        // buttonC 클릭
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = editText.getText();
                listener.onInputMain(input, "C");
            }
        });

        return view;
    }
}
