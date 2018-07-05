package attractionsactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.travel_assistantt.R;

import resturentsactivity.Res_Khazana_Activity;

public class SelectAttractionActivity extends AppCompatActivity {

    ListView list_view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_attraction);


        list_view1 = (ListView) findViewById(R.id.list_view1);

        String[] values = new String[]{
                "Parliament Building",
                "Jamuna Future Park",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,android.R.id.text1,values);

        list_view1.setAdapter(adapter);

        list_view1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int myPosition = position;

                String ClickedValue = list_view1.getItemAtPosition(myPosition).toString();

                Toast.makeText(getApplicationContext(),"U Clicked "+ClickedValue,Toast.LENGTH_LONG).show();

                if(ClickedValue=="Parliament Building"){
                    Intent i = new Intent(SelectAttractionActivity.this, Att_Parliament_Building.class);
                    startActivity(i);
                }

                if(ClickedValue=="Jamuna Future Park"){
                    Intent i = new Intent(SelectAttractionActivity.this, Att_JFP.class);
                    startActivity(i);
                }
            }
        });
    }
}
