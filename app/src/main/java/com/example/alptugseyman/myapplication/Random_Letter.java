package com.example.alptugseyman.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Random_Letter extends AppCompatActivity {

    TextView txtRandom;
    Button random_button;
    String letter ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random__letter);

        txtRandom = (TextView)findViewById(R.id.txtRandom);
        random_button = (Button)findViewById(R.id.random_button);

       random_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
               Random random = new Random();
               for (int i = 0; i<1; i++){
                   char c = letters.charAt(random.nextInt(letters.length()));
                    letter+=c;
                   txtRandom.setText(letter);

               }

           }
       });






    }
}
