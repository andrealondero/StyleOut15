package com.example.styleout15.HomeAccess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.styleout15.DataBase.DBAdapterLogin;
import com.example.styleout15.DataBase.Popolamento;
import com.example.styleout15.DataBase.Vestito;
import com.example.styleout15.FirstAppAccess.MainSecond;
import com.example.styleout15.FromArmadioToMainSecond;
import com.example.styleout15.R;

import java.util.ArrayList;

import static java.lang.reflect.Array.getInt;

public class MainHomeActivity extends AppCompatActivity implements FromArmadioToMainSecond {

    boolean done = false;
    public static DBAdapterLogin db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main_home);
        db = new DBAdapterLogin(this);

        final SharedPreferences prefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        int prefTop = prefs.getInt("TOP_PREFS", 1);
        int prefDown = prefs.getInt("DOWN_PREFS", 1);

        ArrayList<Vestito> vestTop = db.getVestiti("top");
        ArrayList<Vestito> vestUp = db.getVestiti("up");

        ArrayList<Vestito> vest = new ArrayList<>();
        vest.addAll(vestTop);
        vest.addAll(vestUp);
        ArrayList<Vestito> vestDown = db.getVestiti("down");

        for(Vestito v : vest){
            if(v.getGiorni() == prefTop) {
                v.setDisponibile("0");
                v.setGiorni(0);
            }
        }

        for(Vestito v : vestDown){
            if(v.getGiorni() == prefDown) {
                v.setDisponibile("0");
                v.setGiorni(0);
            }
        }

        Fragment fragment = new FragmentHomeOne();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();

        final BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        selectedFragment = new FragmentHomeOne();
                        break;
                    case R.id.navigation_dashboard:
                        selectedFragment = new FragmentArmadio();
                        break;
                    case R.id.navigation_registrati:
                        selectedFragment = new FragmentLogin();
                        break;
                    case R.id.navigation_settings:
                        selectedFragment = new FragmentHomeOne();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                return false;
            }
        });
    }

    @Override
    public void StartNewIntent() {
        Intent intent = new Intent( this, MainSecond.class );
        startActivity( intent );
        finish();

    }
}
