package com.google.travel_assistantt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class LogInScreen extends AppCompatActivity {

    ImageButton signinButton,registerButton;
    EditText email;
    //Button button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        signinButton = (ImageButton) findViewById(R.id.signinButton);
        registerButton = (ImageButton) findViewById(R.id.registerButton);
        email = (EditText) findViewById(R.id.email);
        // button10 = (Button) findViewById(R.id.button10);


        /*
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInScreen.this,MenuScreen.class);
                startActivity(intent);
            }
        });*/

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String em = email.getText();
                if(email.getText().toString().equals("asif")) {
                    Intent intent = new Intent(LogInScreen.this, MenuScreen.class);
                    startActivity(intent);
                }
                else{
                    email.setText("");
                }
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInScreen.this,RegistrationScreen.class);
                startActivity(intent);
            }
        });
    }
}
