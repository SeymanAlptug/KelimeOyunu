package com.example.alptugseyman.myapplication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OyunScreen extends AppCompatActivity {

    private Button ekle, cagir, control;
    private EditText cevap1, cevap2;
    private TextView gör, checktext, soru1, soru2;
    

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    int point = 0;

    final List<String> questionsLsit = new ArrayList<>();
    final List<TextView> tlist = new ArrayList<>();
    final List<EditText> elist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_screen);

        ekle = (Button) findViewById(R.id.button3);
        cevap1 = (EditText) findViewById(R.id.editText);
        cevap2 = (EditText) findViewById(R.id.editText2);
        gör = (TextView) findViewById(R.id.btn_gor);
        checktext = (TextView) findViewById(R.id.txt_kontol);
        control = (Button) findViewById(R.id.button5);
        soru1 = (TextView) findViewById(R.id.textView3);
        soru2 = (TextView) findViewById(R.id.textView2);

        DatabaseReference grq = db.getReference("Sorular");

        tlist.add(soru1);
        tlist.add(soru2);

        elist.add(cevap1);
        elist.add(cevap2);

        grq.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> keys = dataSnapshot.getChildren();
                for (DataSnapshot key : keys) {
                    String question = key.getKey().toString();
                    questionsLsit.add(question);

                }
                Random myRandom = new Random();

                for (int j = 0; j < tlist.size(); j++) {
                    int randomindex = myRandom.nextInt(questionsLsit.size());
                    String randomq = questionsLsit.get(randomindex);
                    tlist.get(j).setText(randomq);
                    questionsLsit.remove(randomq);
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kontrolet();

            }
        });

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ekle();
            }
        });


    }

    //------------------Methodların başlangıcı-------------------




    private void kontrolet() {

        for (int i = 0; i < tlist.size(); i++) {
            String sual = tlist.get(i).getText().toString();
            DatabaseReference kontrol = db.getReference("Sorular").child(sual);
            final List<String> answerList = new ArrayList<>();
            kontrol.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    Iterable<DataSnapshot> keys = dataSnapshot.getChildren();
                    for (DataSnapshot key : keys) {
                        String answer = key.getValue().toString();
                        answerList.add(answer);
                    }
                    for(int i =0;i<elist.size();i++){
                        if (answerList.contains(elist.get(i).getText().toString().trim())) {
                            elist.get(i).getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                            point += 1;

                        } else {
                            elist.get(i).getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                            point +=0;

                        }
                    }
                    checktext.setText("You have " +point+" points.");


                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }
    private void ekle() {

        /*DatabaseReference dbRef2 = db.getReference("Sorular");
        String[] sporlar = {"TENİS",
                "VOLEYBOL",
                "KAYAK",
                "MASA TENİSİ",
                "POLO",
                "SÖRF",
                "SU KAYAĞI",
                "TEKVANDO",
                "SU TOPU",
                "HALTER",
                "JUDO",
                "HENTBOL",
                "GOLF",
                "ATICILIK",
                "ATLETİZM",
                "BASKETBOL",
                "BİNİCİLİK",
                "BİSİKLET",
                "BOKS",
                "JIMNASTIK",
                "ÇİM HOKEYİ",
                "ESKRİM",
                "FUTBOL",
                "KANO",
                "KÜREK",
                "KIŞ SPORLARI",
                "OKCULUK",
                "YELKEN",
                "YÜZME",
                "AİKİDO",
                "ARTİSTİK BUZ PATENİ",
                "AT YARIŞI",
                "BADMİNTOM",
                "BEYZBOL",
                "BİLARDO",
                "BOWLİNG",
                "BUNGEE JUMPİNG",
                "BUZ HOKEYİ",
                "DAĞCILIK",
                "DALGIÇLIK",
                "DART",
                "FİTNESS",
                "GÜREŞ",
                "KAYKAY",
                "KİCK BOKS",
                "KOŞU",
                "KRİKET",
                "KÜREK",
                "LAKROS",
                "MARATON",
                "MOTOR SPORLARI",
                "ORYANTİRİNG",
                "PADDLE BOARDİNG",
                "PAİNTBALL",
                "PARAŞÜT",
                "PARKOUR",
                "PATEN",
                "RAFTİNG",
                "RUGBY",
                "SNOWBOARDİNG",
                "SOKAK KIZAĞI",
                "TRİATLON",
                "UÇURTMA KAYAĞI",
                "WUSHU",
                "YAĞLI GÜREŞ"

        };
        for (int i = 0;i<sporlar.length;i++){
            dbRef2.child("Spor Dalları Nelerdir ?").push().setVal
            ue(sporlar[i]);
        }

        String[] takımlar = {"Akhisar Belediyespor",
                "Alanyaspor",
                "Antalyaspor",
                "Beşiktaş",
                "Bursaspor",
                "BB Erzurumspor",
                "Çaykur Rizespor",
                "Fenerbahçe",
                "Galatasaray",
                "Göztepe",
                "İstanbul Başakşehir",
                "Kasımpaşa",
                "Kayserispor",
                "Konyaspor",
                "MKE Ankaragücü",
                "Sivasspor",
                "Trabzonspor",
                "Yeni Malatyaspor"};
        for(int i =0;i < takımlar.length ; i++){
            dbRef2.child("Futbol Klüpleri Nelerdir ?").push().setValue(takımlar[i]);
        }

        String[] arabaMarkaları = {"Aixam",
                "Alfa Romeo",
                "Ar-Bus",
                "Askam",
                "Aston Martin",
                "Audi",
                "Bentley",
                "Bmc",
                "Bmw",
                "Bugatti",
                "Buick",
                "Busclub",
                "Cadillac",
                "Caterham",
                "Chery",
                "Chevrolet",
                "Chrysler",
                "Citroen",
                "Dacia",
                "Daewoo",
                "Daf",
                "Daihatsu",
                "Dfm",
                "Dodge",
                "Ferrari",
                "Fiat",
                "Folkvan",
                "Ford",
                "Gaz",
                "Geely",
                "Gmc",
                "Güleryüz",
                "Haskar",
                "Hfkanuni",
                "Hino",
                "Honda",
                "Huanghai",
                "Hummer",
                "Hyundai",
                "Ikco",
                "Infiniti",
                "Isuzu",
                "Jac",
                "Jaguar",
                "Karsan",
                "Kia",
                "Lada",
                "Lamborghini",
                "Lancia",
                "Land Rover",
                "Lincoln",
                "Lotus",
                "Mahindra",
                "Man",
                "Maserati",
                "Mazda",
                "Mega",
                "Mercedes",
                "Mercury",
                "Mini",
                "Mitsubishi",
                "Mjt",
                "Neoplan",
                "Nissan",
                "Oltena",
                "Opel",
                "Otokar",
                "Iveco",
                "Peugeot",
                "Pgo",
                "Piaggio",
                "Pontiac",
                "Porsche",
                "Proton",
                "Range Rover",
                "Renault",
                "Rolls Royce-Bentley",
                "Rover",
                "Saab",
                "Samsung",
                "Scam",
                "Scania",
                "Seat",
                "Setra",
                "Skoda",
                "Smart",
                "Ssangyong",
                "Subaru",
                "Suzuki",
                "Tata",
                "Temsa",
                "Tezeller",
                "Tofaş",
                "Toyota",
                "Turkkar",
                "Vanholl",
                "Volkswagen",
                "Volvo",
                "ZiraiTraktör",
                "Zonda"};
        for(int i =0;i < arabaMarkaları.length ; i++){
            dbRef2.child("Araba Markaları Nelerdir ?").push().setValue(arabaMarkaları[i]);
        }*/


    }
}

//-------------------Methodların bitisi-----------------------------


