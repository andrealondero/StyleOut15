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

        int asd = view.getContext().getResources().getIdentifier( "tshirt_red", "drawable", getActivity().getPackageName() );

        db.addVestito( "red", "#C40233", 1, "maglia rossa", "avorio", 3, R.drawable.ic_tshirt );
        db.addVestito( "yellow", "#FFD400", 1, "pantalone", "cacca", 201, R.drawable.pantaloni_sigaretta_tasconi );
        //db.addVestito("arancione", 1, "maglia arancia", "avorio", 1, R.drawable.hoodie_orange);
        //db.addVestito("blu", 1, "pantalone jeans", "cacca", 2, R.drawable.trauser_denim);
        //db.addVestito("blu",1,"maglia verde", "cacca",1, R.drawable.tshirt_denim);
        //db.addVestito("verde",1,"panta verdi","cacca",2, R.drawable.trauser2_olive);
        //db.addVestito("rosso",1, "cardigan red","cacca",1, R.drawable.cardigan_red);

        ArrayList<Vestito> id = db.getVestitiFatti("InvernaleFeriale", pref, postFatto);
        StringBuilder sb = new StringBuilder();
        if(id!=null) {
            int i = 0;
            for (Vestito v1 : id) {

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
