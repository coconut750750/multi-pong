package com.brandon.pong;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button buttonSingle;
    Button buttonDouble;
    Button buttonHelp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        setTitle("Multi Pong");

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonSingle = (Button)findViewById(R.id.buttonSingle);
        buttonDouble = (Button)findViewById(R.id.buttonDouble);
        buttonHelp = (Button)findViewById(R.id.buttonHelp);

        buttonSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment gameModesFragment = new GameModesFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, gameModesFragment);
                fragmentTransaction.commit();
            }
        });

        buttonDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment bluetoothFrag = new BluetoothFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.add(R.id.fragment_container, bluetoothFrag);
                fragmentTransaction.commit();
            }
        });

        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
    }

}
