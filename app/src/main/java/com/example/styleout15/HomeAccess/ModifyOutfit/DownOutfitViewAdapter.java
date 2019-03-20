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
import com.example.styleout15.FirstAppAccess.Down.Down;
import com.example.styleout15.HomeAccess.FragmentArmadio;
import com.example.styleout15.HomeAccess.MainHomeActivity;
import com.example.styleout15.R;

import java.util.ArrayList;


public class DownOutfitViewAdapter extends PagerAdapter {

    private Context dContext;
    private LayoutInflater dLayoutInflater;
    private DBAdapterLogin db = MainHomeActivity.db;
    private Down down = new Down();


    private int[] dImages = dImg();
    private String[] dColors;

    private int[] dImg(){
        ArrayList<Vestito> vest = db.getVestiti( "down" );

        dImages = new int[vest.size()];
        dColors = new String[vest.size()];
        int i = 0;

        for(Vestito v : vest){
            dImages[i] =  down.getLstDown().get(down.getTypeDown().indexOf(Integer.parseInt(v.getTipoVestito())));
            dColors[i] = v.getColorCode();
            i++;
        }

        return dImages;
    }

    public DownOutfitViewAdapter(Context context) {
        this.dContext = context;}

    @Override
    public int getCount() {
        return dImages.length;}

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view == object;}

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        dLayoutInflater = (LayoutInflater) dContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = dLayoutInflater.inflate(R.layout.layout_top_adapter, null);
        ImageView dImageView = (ImageView) view.findViewById(R.id.imageView);
        dImageView.setImageResource( dImages[position]);
        dImageView.setBackgroundColor( Color.parseColor( dColors[position]));

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
