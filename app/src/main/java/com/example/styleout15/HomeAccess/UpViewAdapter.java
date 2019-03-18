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

import com.example.styleout15.DataBase.DBAdapterLogin;
import com.example.styleout15.DataBase.Vestito;
import com.example.styleout15.FirstAppAccess.Up.Up;
import com.example.styleout15.R;

import java.util.ArrayList;


public class UpViewAdapter extends PagerAdapter {

    private Context uContext;
    private LayoutInflater uLayoutInflater;
    private DBAdapterLogin db = FragmentArmadio.db;
    private Up up = new Up();


    private int[] uImages = uimg();
    private String[] uColors;

    private int[] uimg(){
        ArrayList<Vestito> vest = db.getVestiti( "up" );

        uImages = new int[vest.size()];
        uColors = new String[vest.size()];
        int i = 0;

        for(Vestito v : vest){
            uImages[i] =  up.getLstUp().get(up.getTypeUp().indexOf(Integer.parseInt(v.getTipoVestito())));
            uColors[i] = v.getColorCode();
            i++;
        }

        return uImages;
    }

    public UpViewAdapter(Context context) {
        this.uContext = context;}

    @Override
    public int getCount() {
        return uImages.length;}

    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view == object;}

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        uLayoutInflater = (LayoutInflater) uContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = uLayoutInflater.inflate(R.layout.layout_up_adapter, null);
        ImageView uImageView = (ImageView) view.findViewById(R.id.upAdapterView);
        uImageView.setImageResource(uImages[position]);
        uImageView.setBackgroundColor( Color.parseColor(uColors[position]));

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
