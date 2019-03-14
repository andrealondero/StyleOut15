package com.example.styleout15.FirstAppAccess;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.styleout15.R;

public class DoneFragment extends Fragment {

    View doneView;

    public DoneFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        doneView = inflater.inflate( R.layout.done_fragment, container, false );

        Button button = doneView.findViewById( R.id.go_home );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainSecond)getActivity()).startMyIntent();
            }
        } );
        return doneView;
    }
}
