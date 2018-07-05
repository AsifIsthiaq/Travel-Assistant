package com.google.travel_assistantt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RegistrationScreen extends AppCompatActivity {

    ImageButton signupreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);

        signupreg = (ImageButton)findViewById(R.id.signupreg);

        signupreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationScreen.this,MenuScreen.class);
                startActivity(intent);
            }
        });
    }
}
