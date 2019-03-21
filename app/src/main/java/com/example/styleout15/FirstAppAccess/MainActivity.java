package com.example.styleout15.FirstAppAccess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.styleout15.DataBase.Popolamento;
import com.example.styleout15.HomeAccess.MainHomeActivity;
import com.example.styleout15.R;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarTop;
    private SeekBar seekBarDown;
    private ImageButton btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        final Intent intent = new Intent(this, MainSecond.class);

        final SharedPreferences prefs = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String logPref = prefs.getString("KEY FIRST ACCESS", "first");
        final SharedPreferences.Editor editor = prefs.edit();
        if (logPref.equals("not first")) {
            startActivity(new Intent(MainActivity.this, MainHomeActivity.class ));
        }
        else {
            editor.putString("KEY FIRST ACCESS", "not first");
            editor.commit();
            new Popolamento(this);
        }
        setContentView( R.layout.activity_main );

        seekBarTop = findViewById(R.id.seekBar);
        seekBarDown = findViewById(R.id.seekBar1);
        btnDone = findViewById(R.id.done);

        int topPref = prefs.getInt("TOP_PREFS", 1);
        int downPref = prefs.getInt("DOWN_PREFS", 1);

        seekBarTop.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int topProgress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                topProgress = progress+1;
                editor.putInt("TOP_PREFS", topProgress);
                editor.commit();
                Toast.makeText(getApplicationContext(), ""+prefs.getInt("TOP_PREFS", 1), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        seekBarDown.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int downProgress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                downProgress = progress+1;
                editor.putInt("DOWN_PREFS", downProgress);
                editor.commit();
                Toast.makeText(getApplicationContext(), ""+prefs.getInt("DOWN_PREFS", 1), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
}
