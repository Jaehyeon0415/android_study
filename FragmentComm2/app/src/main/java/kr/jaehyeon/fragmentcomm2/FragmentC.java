package kr.jaehyeon.fragmentcomm2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentC extends Fragment {
    private CharSequence value = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);

        EditText editText = view.findViewById(R.id.editTextC);
        editText.setText(value);
        return view;
    }

    public void updateEditTextA(CharSequence newInput) {
        value = newInput;
    }
}
