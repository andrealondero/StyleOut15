package com.example.styleout15.FirstAppAccess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.styleout15.DataBase.Popolamento;
import com.example.styleout15.HomeAccess.MainHomeActivity;
import com.example.styleout15.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        final SharedPreferences prefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String logPref = prefs.getString("KEY FIRST ACCESS", "first");
        SharedPreferences.Editor editor = prefs.edit();
        if (logPref.equals("not first")) {
            startActivity(new Intent(MainActivity.this, MainHomeActivity.class ));
        }
        else {
            editor.putString("KEY FIRST ACCESS", "not first");
            editor.commit();
            new Popolamento(this);
        }
        setContentView( R.layout.activity_main );
        final Button button = findViewById( R.id.done );
        final CheckBox checkelegant = findViewById( R.id.elegantaccess );
        final CheckBox checkformal = findViewById( R.id.formalaccess );
        final CheckBox checkcasual = findViewById( R.id.casualaccess );
        final CheckBox checkusual = findViewById( R.id.usualaccess );

        checkelegant.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    button.setEnabled( true );
                    startActivity( new Intent( MainActivity.this, MainSecond.class ) );
                } else {
                    button.setEnabled( false );
                }
            }
        } );

        checkformal.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    button.setEnabled( true );
                    startActivity( new Intent( MainActivity.this, MainSecond.class ) );
                } else {
                    button.setEnabled( false );
                }
            }
        } );

        checkcasual.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    button.setEnabled( true );
                    startActivity( new Intent( MainActivity.this, MainSecond.class ) );
                } else {
                    button.setEnabled( false );
                }
            }
        } );

        checkusual.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (buttonView.isChecked()) {
                    button.setEnabled( true );
                    startActivity( new Intent( MainActivity.this, MainSecond.class ) );
                } else {
                    button.setEnabled( false );
                }
            }
        } );

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
