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
import android.widget.Toast;

import com.example.styleout15.DataBase.DBAdapterLogin;
import com.example.styleout15.HomeAccess.ModifyOutfit.DownOutfitViewAdapter;
import com.example.styleout15.HomeAccess.ModifyOutfit.TopOutfitViewAdapter;
import com.example.styleout15.R;

import static com.example.styleout15.HomeAccess.FragmentHomeOne.selectedOutfit;

public class FragmentModificaOutfit extends Fragment {

    public static DBAdapterLogin db;
    ImageButton confirmOutfit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment_modifica_outfit, container, false );
        db = new DBAdapterLogin(view.getContext());

        confirmOutfit = view.findViewById(R.id.btnConfirmoutfit);
        confirmOutfit.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    db.addOutfitFatto(selectedOutfit.get(0).getSelected(), selectedOutfit);
                    Toast.makeText(getContext(), "OUTFIT ADDED, PRESS AGAIN", Toast.LENGTH_SHORT).show();
                }
        } );

        ViewPager viewPager;
        ViewPager viewPager2;

        viewPager = view.findViewById(R.id.top_outfit_viewpager);
        viewPager2 = view.findViewById(R.id.down_outfit_viewpager);

        TopOutfitViewAdapter topoutfitViewAdapter = new TopOutfitViewAdapter(getContext());
        viewPager.setAdapter(topoutfitViewAdapter);
        DownOutfitViewAdapter downoutfitViewAdapter = new DownOutfitViewAdapter(getContext());
        viewPager2.setAdapter(downoutfitViewAdapter);

        return view;
    }
}
