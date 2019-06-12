package com.example.alptugseyman.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OyunSecim extends AppCompatActivity {

    Button rastgele, arkadas;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_secim);


        rastgele = (Button) findViewById(R.id.button7);
        arkadas = (Button) findViewById(R.id.button6);
        name = (TextView) findViewById(R.id.textView);
        name.setText(getIntent().getExtras().getString("veri"));

        rastgele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OyunSecim.this,OyunScreen.class);
                startActivity(intent);
            }
        });

        arkadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OyunSecim.this,OyunScreen.class);
                startActivity(intent);
            }
        });





        }


    }

