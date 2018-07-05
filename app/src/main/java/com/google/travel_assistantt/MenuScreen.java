package com.google.travel_assistantt;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import attractionsactivity.SelectCityAttraction;
import hotelsactivity.SelectCity;
import resturentsactivity.SelectCity_RandA;

public class MenuScreen extends AppCompatActivity {

    Button hotel,restu,attraction,help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);



        hotel = (Button) findViewById(R.id.hotel);
        restu = (Button) findViewById(R.id.restu);
        attraction = (Button) findViewById(R.id.attraction);
        help = (Button) findViewById(R.id.help);


        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCity(v);
            }
        });

        restu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuScreen.this, SelectCity_RandA.class);
                startActivity(i);
            }
        });

        attraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuScreen.this, SelectCityAttraction.class);
                startActivity(i);
            }
        });


    }

    public void clickCity(View v){
        Intent i = new Intent(MenuScreen.this, SelectCity.class);
        startActivity(i);
    }
}