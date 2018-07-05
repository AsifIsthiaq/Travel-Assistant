package hotelsactivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.travel_assistantt.R;

import data.DatabaseHandler;
import model.MyHotel;


public class Input_List_Activity extends Activity {

    private EditText title;
    private EditText content;
    private Button saveButton;
    private Button listButton;
    private DatabaseHandler dba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input__list_);

        dba = new DatabaseHandler(Input_List_Activity.this);

        title = (EditText) findViewById(R.id.titleEditText);
        content = (EditText) findViewById(R.id.wishEditText);
        saveButton = (Button) findViewById(R.id.saveButton);
        listButton = (Button) findViewById(R.id.listButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDB();
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Input_List_Activity.this, DisplayHotelsActivity.class);
                startActivity(i);
            }
        });



    }

    private void saveToDB() {

        MyHotel wish = new MyHotel();
        wish.setTitle(title.getText().toString().trim());
        wish.setContent(content.getText().toString().trim());



        dba.addWishes(wish);
        dba.close();

        //clear
        title.setText("");
        content.setText("");


        Intent i = new Intent(Input_List_Activity.this, DisplayHotelsActivity.class);
        startActivity(i);



    }


}
