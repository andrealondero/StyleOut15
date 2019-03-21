package com.example.styleout15.HomeAccess;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.styleout15.DataBase.DBAdapterLogin;
import com.example.styleout15.DataBase.Vestito;
import com.example.styleout15.FirstAppAccess.Down.Down;
import com.example.styleout15.FirstAppAccess.Top.Top;
import com.example.styleout15.FirstAppAccess.Up.Up;
import com.example.styleout15.R;
import com.example.styleout15.Utility.Preferenze;

import java.util.ArrayList;

public class FragmentHomeTwo extends Fragment {

    DBAdapterLogin db;
    ImageView imageView;
    ImageView imageView2;
    ArrayList<Vestito> selectedOutfit;
    ArrayList<Integer> postFatto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate( R.layout.fragment_home_two, container, false );

        db = new DBAdapterLogin( view.getContext() );
        final Preferenze pref = new Preferenze();
        final Up up = new Up();
        final Down down = new Down();
        final Top top = new Top();
        postFatto = new ArrayList<>();
        selectedOutfit = new ArrayList<>();

        imageView = view.findViewById( R.id.upperView );
        imageView2 = view.findViewById( R.id.downView );

        ArrayList<Vestito> id = FragmentHomeOne.selectedOutfit;
        StringBuilder sb = new StringBuilder();
        if(id!=null) {
            int i = 0;
            for (Vestito v1 : id) {
                v1.setGiorni(v1.getGiorni()+1);

                int res = 0;
                if(Integer.parseInt(v1.getTipoVestito())>100 && Integer.parseInt(v1.getTipoVestito()) < 200)
                    res = up.getLstUp().get(up.getTypeUp().indexOf(Integer.parseInt(v1.getTipoVestito())));

                else if(Integer.parseInt(v1.getTipoVestito())<100) {
                    res = top.getLstTop().get(top.getTypeTop().indexOf(Integer.parseInt(v1.getTipoVestito())));
                    imageView.setImageResource(res);
                    imageView.setBackgroundColor( Color.parseColor(v1.getColorCode()));
                }

                else {
                    res = down.getLstDown().get(down.getTypeDown().indexOf(Integer.parseInt(v1.getTipoVestito())));
                    imageView2.setImageResource(res);
                    imageView2.setBackgroundColor(Color.parseColor(v1.getColorCode()));
                }
            }
        }

        return view;
    }
}
