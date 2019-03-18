package com.example.styleout15.FirstAppAccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.styleout15.FromDoneToHome;
import com.example.styleout15.HomeAccess.MainHomeActivity;
import com.example.styleout15.R;

public class MainSecond extends AppCompatActivity implements FromDoneToHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_second );
        TabLayout tabLayout;
        ViewPager viewPager;
        FragmentAdapter adapterFragment;

        tabLayout = (TabLayout) findViewById( R.id.tabs );
        viewPager = (ViewPager) findViewById( R.id.container );
        adapterFragment = new FragmentAdapter( getSupportFragmentManager() );

        adapterFragment.AddFragment( new TopFragment(), "TOP" );
        adapterFragment.AddFragment( new UpFragment(), "UP" );
        adapterFragment.AddFragment( new DownFragment(), "DOWN" );
        adapterFragment.AddFragment( new DoneFragment(), "DONE" );
        viewPager.setAdapter( adapterFragment );
        tabLayout.setupWithViewPager( viewPager );

        tabLayout.getTabAt( 0 ).setIcon( R.drawable.hoodie_icona );
        tabLayout.getTabAt( 1 ).setIcon( R.drawable.tshirt_icona );
        tabLayout.getTabAt( 2 ).setIcon( R.drawable.pantalone_icona );
        tabLayout.getTabAt( 3 ).setIcon( R.drawable.appendino );
    }

    @Override
    public void startMyIntent() {
        Intent intent = new Intent( this, MainHomeActivity.class );
        startActivity( intent );
        finish();
    }
}
