package com.example.styleout15.HomeAccess;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.styleout15.DataBase.DBAdapterLogin;
import com.example.styleout15.DataBase.Vestito;
import com.example.styleout15.FirstAppAccess.Top.Top;
import com.example.styleout15.R;

import java.util.ArrayList;


public class TopViewAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private DBAdapterLogin db = MainHomeActivity.db;
    private Top top = new Top();


    private int[] images = imagess();
    private String[] colors;

    private int[] imagess(){
        ArrayList<Vestito> vest = db.getVestiti( "top" );

        images = new int[vest.size()];
        colors = new String[vest.size()];
        int i = 0;

        for(Vestito v : vest){
            images[i] =  top.getLstTop().get(top.getTypeTop().indexOf(Integer.parseInt(v.getTipoVestito())));
            colors[i] = v.getColorCode();
            i++;
        }

        return images;
    }

    public TopViewAdapter(Context context) {
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
