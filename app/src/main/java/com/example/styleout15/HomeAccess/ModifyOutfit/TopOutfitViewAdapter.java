package com.example.styleout15.HomeAccess.ModifyOutfit;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.styleout15.DataBase.DBAdapterLogin;
import com.example.styleout15.DataBase.Vestito;
import com.example.styleout15.FirstAppAccess.Top.Top;
import com.example.styleout15.FirstAppAccess.Up.Up;
import com.example.styleout15.HomeAccess.FragmentArmadio;
import com.example.styleout15.HomeAccess.MainHomeActivity;
import com.example.styleout15.R;

import java.util.ArrayList;


public class TopOutfitViewAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private DBAdapterLogin db = MainHomeActivity.db;
    private Top top = new Top();
    private Up up = new Up();


    private int[] images = imagess();
    private String[] colors;
    public static ArrayList<Vestito> vest = new ArrayList<>();

    public static ArrayList<Vestito> getVest() {
        return vest;
    }

    public static void setVest(ArrayList<Vestito> vest) {
        TopOutfitViewAdapter.vest = vest;
    }

    private int[] imagess(){
        ArrayList<Vestito> vest1 = db.getVestiti("top");
        ArrayList<Vestito> vest2 = db.getVestiti("up");

        vest = new ArrayList<>();
        vest.addAll(vest1);
        vest.addAll(vest2);

        images = new int[vest1.size()+vest2.size()];
        colors = new String[vest1.size()+vest2.size()];

        int i = 0;

        for(Vestito v : vest1){
            images[i] =  top.getLstTop().get(top.getTypeTop().indexOf(Integer.parseInt(v.getTipoVestito())));
            colors[i] = v.getColorCode();
            i++;
        }

        for(Vestito v : vest2){
            images[i] =  up.getLstUp().get(up.getTypeUp().indexOf(Integer.parseInt(v.getTipoVestito())));
            colors[i] = v.getColorCode();
            i++;
        }

        return images;
    }

    public TopOutfitViewAdapter(Context context) {
        this.context = context;}

    @Override
    public int getCount() {
        return images.length;}

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view == object;}

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_top_adapter, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        imageView.setBackgroundColor( Color.parseColor(colors[position]));

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
