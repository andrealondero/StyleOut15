package com.example.styleout15.HomeAccess;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.styleout15.DataBase.DBAdapterLogin;
import com.example.styleout15.R;

public class FragmentArmadio extends Fragment {

    public static DBAdapterLogin db;
    ImageButton addButton;
    ImageButton modifyButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment_armadio, container, false );
        db = new DBAdapterLogin(view.getContext());

        addButton = view.findViewById(R.id.btnAddwear);
        modifyButton = view.findViewById(R.id.btnModifywear);

        addButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentHomeTwo = new FragmentHomeTwo();
                getFragmentManager().beginTransaction().replace( R.id.container, fragmentHomeTwo ).commit();
            }
        } );

        ViewPager viewPager;
        ViewPager viewPager1;
        ViewPager viewPager2;

        viewPager = view.findViewById(R.id.top_viewpager);
        viewPager1 = view.findViewById(R.id.up_viewpager);
        viewPager2 = view.findViewById(R.id.down_viewpager);

        TopViewAdapter topViewAdapter = new TopViewAdapter(getContext());
        viewPager.setAdapter(topViewAdapter);
        UpViewAdapter upViewAdapter = new UpViewAdapter(getContext());
        viewPager1.setAdapter(upViewAdapter);
        DownViewAdapter downViewAdapter = new DownViewAdapter(getContext());
        viewPager2.setAdapter(downViewAdapter);


        return view;
    }




}
