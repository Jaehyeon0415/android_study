package kr.jaehyeon.movierating;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VoteFragment extends Fragment {
    private MyDBHelper dbHelper;

    public VoteFragment(MyDBHelper myDBHelper) {
        dbHelper = myDBHelper;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vote, container, false);

        GridView gridView = rootView.findViewById(R.id.grid_view1);
        MyGridAdapter myGridAdapter = new MyGridAdapter(rootView.getContext(), dbHelper);
        gridView.setAdapter(myGridAdapter);

        return rootView;
    }
}
